
import org.apache.commons.vfs2.*

def fsManager = VFS.manager
def file = fsManager.resolveFile("gz:tar:${basedir}/target/dependencies/vfs-invoker-groovy-1.0.0-SNAPSHOT.tar!/hello.txt")

println file.text

assert file.text.contains('Hello')
