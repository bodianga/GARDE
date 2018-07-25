// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bodianga/IdeaProjects/git/theGardener/conf/routes
// @DATE:Tue Jul 24 16:16:48 CEST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:32
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
        
          if (file1 == """ + implicitly[play.api.mvc.JavascriptLiteral[String]].to("index.html") + """) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/docs/"})
          }
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/docs/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
          }
        
        }
      """
    )
  
    // @LINE:37
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:14
  class ReverseProjectController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def linkProjectToHierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.linkProjectToHierarchy",
      """
        function(id0,hierarchyId1) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/hierarchy/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("hierarchyId", hierarchyId1))})
        }
      """
    )
  
    // @LINE:15
    def getAllProjects: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.getAllProjects",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects"})
        }
      """
    )
  
    // @LINE:18
    def deleteProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.deleteProject",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:19
    def synchronizeProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.synchronizeProject",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/synchronize"})
        }
      """
    )
  
    // @LINE:16
    def getProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.getProject",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:17
    def updateProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.updateProject",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:14
    def registerProject: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.registerProject",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects"})
        }
      """
    )
  
    // @LINE:20
    def getLinkProjectToHierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.getLinkProjectToHierarchy",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/hierarchy"})
        }
      """
    )
  
    // @LINE:22
    def deleteLinkProjectToHierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ProjectController.deleteLinkProjectToHierarchy",
      """
        function(id0,hierarchyId1) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/projects/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0)) + "/hierarchy/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("hierarchyId", hierarchyId1))})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseHierarchyController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def getAllHierarchies: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HierarchyController.getAllHierarchies",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/hierarchy"})
        }
      """
    )
  
    // @LINE:29
    def deleteHierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HierarchyController.deleteHierarchy",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/hierarchy/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:28
    def updateHierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HierarchyController.updateHierarchy",
      """
        function(id0) {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/hierarchy/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:26
    def addHierarchy: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HierarchyController.addHierarchy",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/hierarchy"})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseFeatureController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def feature: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FeatureController.feature",
      """
        function(project0,feature1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/features/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("feature", feature1))})
        }
      """
    )
  
  }

  // @LINE:33
  class ReverseApiHelpController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def getResources: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiHelpController.getResources",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/docs/swagger.json"})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:9
    def feature: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.feature",
      """
        function(project0,feature1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "features/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("project", project0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("feature", feature1))})
        }
      """
    )
  
  }


}
