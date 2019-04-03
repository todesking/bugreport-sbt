val foo = RootProject(file("../foo"))
val main = (project in file("."))
  .dependsOn(foo)
