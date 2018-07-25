// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bodianga/IdeaProjects/git/theGardener/conf/routes
// @DATE:Tue Jul 24 16:16:48 CEST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:32
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:32
    def at(file:String): Call = {
    
      (file: @unchecked) match {
      
        // @LINE:32
        case (file) if file == "index.html" =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/swagger-ui"), ("file", "index.html"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "api/docs/")
      
        // @LINE:34
        case (file)  =>
          implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/swagger-ui"))); _rrc
          Call("GET", _prefix + { _defaultPrefix } + "api/docs/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
      
      }
    
    }
  
    // @LINE:37
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:14
  class ReverseProjectController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def linkProjectToHierarchy(id:String, hierarchyId:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/hierarchy/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("hierarchyId", hierarchyId)))
    }
  
    // @LINE:15
    def getAllProjects(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/projects")
    }
  
    // @LINE:18
    def deleteProject(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:19
    def synchronizeProject(id:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/synchronize")
    }
  
    // @LINE:16
    def getProject(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:17
    def updateProject(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:14
    def registerProject(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/projects")
    }
  
    // @LINE:20
    def getLinkProjectToHierarchy(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/hierarchy")
    }
  
    // @LINE:22
    def deleteLinkProjectToHierarchy(id:String, hierarchyId:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/projects/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)) + "/hierarchy/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("hierarchyId", hierarchyId)))
    }
  
  }

  // @LINE:26
  class ReverseHierarchyController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def getAllHierarchies(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/hierarchy")
    }
  
    // @LINE:29
    def deleteHierarchy(id:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "api/hierarchy/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:28
    def updateHierarchy(id:String): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "api/hierarchy/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:26
    def addHierarchy(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "api/hierarchy")
    }
  
  }

  // @LINE:12
  class ReverseFeatureController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def feature(project:String, feature:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/features/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("feature", feature)))
    }
  
  }

  // @LINE:33
  class ReverseApiHelpController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def getResources(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/docs/swagger.json")
    }
  
  }

  // @LINE:7
  class ReverseApplication(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def feature(project:String, feature:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "features/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("project", project)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("feature", feature)))
    }
  
  }


}
