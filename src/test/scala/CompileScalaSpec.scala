import org.specs2.mutable._
import org.specs2.mock.Mockito
import java.io.File
import kr.co.hkcb.tools.chm.CompileScala

object CompileScalaSpec extends Specification with Mockito {
  import CompileScala._
  "getTocDirectories" should {
    "return the expected list" in {
      def getMockedFile(name: String, isDir: Boolean): File = {
        val mockedFile = mock[File]
        mockedFile.isDirectory returns isDir
        mockedFile.getName returns name
        mockedFile
      }
      val baseDir = mock[File]
      baseDir.listFiles returns Array(
        getMockedFile("index.html", false),
        getMockedFile("index.js", false),
        getMockedFile("package.html", false),
        getMockedFile("anorm", true),
        getMockedFile("controllers", true),
        getMockedFile("index", true),
        getMockedFile("lib", true),
        getMockedFile("play", true),
        getMockedFile("views", true)
      )
      val actual = getTocDirectories(baseDir)
      val expectedNames = Seq("anorm", "controllers", "play", "views")
      for (file <- actual)
      yield {
        file.isDirectory should beTrue
        expectedNames should contain(file.getName)
      }
    }
  }
}
