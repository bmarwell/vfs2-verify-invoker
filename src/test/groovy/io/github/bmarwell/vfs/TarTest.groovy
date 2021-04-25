package io.github.bmarwell.vfs

import org.junit.jupiter.api.Test;

import org.apache.commons.vfs2.*

import java.nio.charset.StandardCharsets


class TarTest {

    @Test
    void 'test vfs2 can read tar files'() {
        def basedir = new File('.').canonicalFile.absoluteFile
        def tarfile = new File(basedir, "target/vfs-invoker-groovy-1.0.0-SNAPSHOT.tar").canonicalFile.absoluteFile

        println "path: ${tarfile.absolutePath}"
        println "is absolute: ${tarfile.isAbsolute()}"
        println "exists: ${tarfile.exists()}"

        def fsManager = VFS.manager
        def helloTxt = fsManager.resolveFile("tar:file:///${tarfile}!/hello.txt")


        def text = helloTxt.content.getString(StandardCharsets.UTF_8)
        println text

        assert text.contains('Hello')

    }

}
