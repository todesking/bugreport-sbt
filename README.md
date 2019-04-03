* `foo`: Sub project
* `foo-bar`: Main project using `val sub = RootProject(file("../sub"))`
* `foo-bar2`: Main project using `val sub = project in file("sub")` and symblic link.
* `bar-foo`: Same as `foo-bar`. Only difference is its name.

1. `cd $project_dir` (i.e. `foo-bar`, `foo-bar2`, `bar-foo`)
2. Run `sbt ~compile`
3. Edit `$project_dir/src/main/scala/A.scala`
  * In `foo-bar` and `foo-bar2`, sbt ignore changes and waiting forever.
  * In `bar-foo`, sbt run compile task again.

The key is project directory name: When the project in directory `X-Y` referres the project in directory `X`, source changes are ignored. But if `Y-X` referres `X`, its OK.
I have no idea why.
