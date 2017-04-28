package org.gradle.script.lang.kotlin.samples

import org.gradle.script.lang.kotlin.fixtures.AbstractIntegrationTest

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.io.File
import java.nio.file.Paths

class BuildScanSampleTest : AbstractSampleTest("build-scan")
class DomainObjectsScanSampleTest : AbstractSampleTest("domain-objects")
class ExtraPropertiesScanSampleTest : AbstractSampleTest("extra-properties")
class GroovyInteropScanSampleTest : AbstractSampleTest("groovy-interop")
@Ignore class HelloAndroidSampleTest : AbstractSampleTest("hello-android")
class HelloCoroutinesSampleTest : AbstractSampleTest("hello-coroutines")
class HelloKotlinSampleTest : AbstractSampleTest("hello-kotlin")
class HelloWorldSampleTest : AbstractSampleTest("hello-world")
class ModularitySampleTest : AbstractSampleTest("modularity")
class MultiKotlinProjectSampleTest : AbstractSampleTest("multi-kotlin-project")
class MultiKotlinProjectConfigInjectionSampleTest : AbstractSampleTest("multi-kotlin-project-config-injection")
class MultiKotlinProjectWithBuildSrcSampleTest : AbstractSampleTest("multi-kotlin-project-with-buildSrc")
class ProjectPropertiesSampleTest : AbstractSampleTest("project-properties")
class TaskDependenciesSampleTest : AbstractSampleTest("task-dependencies")

abstract class AbstractSampleTest(val sampleName: String) : AbstractIntegrationTest()
{
    @Before
    fun populateProjectRootWithSample()
    {
        val sampleDir = Paths.get("samples", sampleName).toFile()
        sampleDir.copyRecursively(projectRoot)
        listOf(".gradle", "build").map { File(projectRoot, it) }.filter { it.exists() }.forEach {
            it.deleteRecursively()
        }
    }

    @Test
    fun `tasks task succeeds`()
    {
        build("tasks")
    }
}
