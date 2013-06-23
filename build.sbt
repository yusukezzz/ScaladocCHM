import AssemblyKeys._

scalaVersion := "2.10.2"

name := "ScaladocCHM"

version := "1.0"

libraryDependencies ++= Seq(
  "javax.transaction"             %  "jta"           % "1.1",
  "com.github.scala-incubator.io" %% "scala-io-core" % "0.4.1",
  "org.specs2"                    %% "specs2"        % "2.0"   % "test",
  "org.mockito"                   %  "mockito-core"  % "1.9.5" % "test"
)

scalacOptions ++= Seq("-deprecation", "-feature")

scalacOptions in Test ++= Seq("-Yrangepos")

assemblySettings

jarName in assembly := "ScaladocCHM.jar"
