
import org.apache.commons.vfs2.*

import java.nio.charset.StandardCharsets

def fsManager = VFS.manager

def tarfile = new File(basedir, "target/dependency/vfs-invoker-groovy-1.0.0-SNAPSHOT.tar").canonicalFile.absoluteFile

println "path: ${tarfile.absolutePath}"
println "is absolute: ${tarfile.isAbsolute()}"
println "exists: ${tarfile.exists()}"

def helloTxt = fsManager.resolveFile("tar:file:///${tarfile.absolutePath}!/hello.txt")

def text = helloTxt.content.getString(StandardCharsets.UTF_8)
println text

assert text.contains('Hello')
