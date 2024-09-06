pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TestModularityApp"
include(":app")
include(":core_data")
include(":module-injector")
include(":core_database")

include(":core_network")

include(":search_feature_api")
include(":search_feature_impl")
include(":auth_feature_api")
include(":auth_feature_impl")
include(":core_utils")
