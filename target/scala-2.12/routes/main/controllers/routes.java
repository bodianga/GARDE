// @GENERATOR:play-routes-compiler
// @SOURCE:/home/bodianga/IdeaProjects/git/theGardener/conf/routes
// @DATE:Tue Jul 24 16:16:48 CEST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseProjectController ProjectController = new controllers.ReverseProjectController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHierarchyController HierarchyController = new controllers.ReverseHierarchyController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFeatureController FeatureController = new controllers.ReverseFeatureController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApiHelpController ApiHelpController = new controllers.ReverseApiHelpController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApplication Application = new controllers.ReverseApplication(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseProjectController ProjectController = new controllers.javascript.ReverseProjectController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHierarchyController HierarchyController = new controllers.javascript.ReverseHierarchyController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFeatureController FeatureController = new controllers.javascript.ReverseFeatureController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApiHelpController ApiHelpController = new controllers.javascript.ReverseApiHelpController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApplication Application = new controllers.javascript.ReverseApplication(RoutesPrefix.byNamePrefix());
  }

}
