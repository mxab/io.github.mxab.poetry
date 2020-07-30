import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

open class PoetryTask : DefaultTask() {

    @Input
    var poetryExec = project.objects.property(String::class.java)

    @Input
    var args = project.objects.listProperty(String::class.java)

    @TaskAction
    fun run() {
        this.project.exec {
            it.executable = poetryExec.get()
            it.args = args.get()
        }
    }
}
