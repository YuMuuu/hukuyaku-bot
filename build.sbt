name := "hukuyaku-bot"

version := "0.1"

scalaVersion := "2.13.3"


resolvers ++= Seq(
 Resolver.jcenterRepo,
 "spring-lib-release" at "https://repo.spring.io/libs-release/",
)

libraryDependencies ++= Seq(
  "com.jagrosh" % "jda-utilities" % "3.0.4" pomOnly(),
  "net.dv8tion" % "JDA" % "4.2.0_197",
  "com.softwaremill.macwire" %% "macros" % "2.3.7" % "provided",
  "com.github.pureconfig" %% "pureconfig" % "0.14.0",
)


