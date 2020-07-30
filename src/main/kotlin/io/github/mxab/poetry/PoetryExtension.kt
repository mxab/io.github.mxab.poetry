package io.github.mxab.poetry

import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property


open class PoetryExtension(objects: ObjectFactory) {

    var poetryExec: Property<String> = objects.property(String::class.java).convention("poetry")

}
