package dev.love.winter.catchbottle.buildlogic.extension

import org.gradle.api.UnknownProjectException
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project
import kotlin.collections.forEach

/**
 * Configure dependencies 레퍼런스 참고:
 * https://developer.android.com/build/dependencies
 */
fun DependencyHandlerScope.implementations(vararg deps: Any) {
    deps.forEach { "implementation"(it) }
}

/**
 * 구현 모듈(impl)과 추상화 모듈(api) 의존 관계를 정의합니다.
 *
 * @param depsRoot required.
 *                 (:api, :impl) 구조로 나뉜 디렉토리의 루트 값을 입력합니다.
 * @param subModules optional.
 *                   루트 디렉토리 하위 모듈을 선언합니다.
 *                   대부분 (:api, :impl) 구성입니다.
 *
 * (:api): public 인터페이스와 모듈만 노출합니다.
 * (:impl): :api 모듈의 인터페이스를 상속받아 구현 코드를 작성합니다.
 *
 * runtimeOnly 효과:
 * 구현 모듈(:impl)의 변경 사항으로 다른 모듈에 리빌드 need 를 전파하지 않습니다.
 * 런타임에만 구현(:impl)이 로드되어 개발중 리빌드 타임을 개선합니다.
 *
 * 추상, 구현 모듈 관련 레퍼런스 참고:
 * https://developer.android.com/topic/modularization/patterns#how_to_implement
 */
fun DependencyHandlerScope.configureModuleDependencies(
    vararg depsRoot: ProjectDependency,
    subModules: List<String> = listOf("api", "impl")
) {
    depsRoot.forEach { dep ->
        val projectPath = dep.dependencyProject.path
        subModules.forEach { subModule ->
            val subProjectPath = "$projectPath:$subModule"
            try {
                when (subModule) {
                    "api" -> "implementation"(project(subProjectPath))
                    "impl" -> "runtimeOnly"(project(subProjectPath))
                    else -> "implementation"(project(subProjectPath))
                }
            } catch (e: UnknownProjectException) {
                println("Subproject $subProjectPath does not exist. Skipping...")
            }
        }
    }
}
