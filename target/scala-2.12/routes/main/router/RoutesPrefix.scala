// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bodianga/IdeaProjects/git/theGardener/conf/routes
// @DATE:Tue Jul 24 16:16:48 CEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
