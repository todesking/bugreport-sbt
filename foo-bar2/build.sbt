val foo = project in file("foo")
val main = (project in file("."))
  .dependsOn(foo)
