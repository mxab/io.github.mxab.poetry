/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.github.mxab.poetry

import java.io.File
import org.gradle.testkit.runner.GradleRunner
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * A simple functional test for the 'io.github.mxab.poetry.greeting' plugin.
 */
class PoetryPluginFunctionalTest {
    @Test fun `can run task`() {
        // Setup the test build
        val projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('io.github.mxab.poetry')
            }
        """)
        projectDir.resolve("pyproject.toml").writeText("""
            [tool.poetry]
            name = "bert"
            version = "0.1.0"
            description = ""
            authors = ["Max Fröhlich <maxbruchmann@gmail.com>"]
            
            [tool.poetry.dependencies]
            python = "^3.6"
            [tool.poetry.dev-dependencies]
            pytest = "^5.3"
            
            [build-system]
            requires = ["poetry>=0.12"]
            build-backend = "poetry.masonry.api"
        """)


        // Run the build
        val runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("poetryInstall")
        runner.withProjectDir(projectDir)
        val result = runner.build();

        // Verify the result
        assertTrue(result.output.contains("Installing"))
    }
}
