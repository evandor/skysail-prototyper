package io.skysail.server.app.livingspec;


import org.osgi.service.component.annotations.*;

import io.skysail.domain.core.repos.DbRepository;
import io.skysail.server.db.*;

/**
 * generated from repository.stg
 */
@Component(immediate = true, property = "name=StoryMapsRepository")
public class StoryMapRepository extends GraphDbRepository<io.skysail.server.app.livingspec.storymap.StoryMap> implements DbRepository {

    @Reference
    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

    public void unsetDbService(DbService dbService) {
        this.dbService = null;
    }

    @Activate
    public void activate() {
        //log.debug("activating io.skysail.server.app.livingspec.storymap.StoryMap" Repository);
        //dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.livingspec.storymap.StoryMap.class));
        //dbService.register(io.skysail.server.app.livingspec.storymap.StoryMap.class);
        dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.livingspec.storymap.StoryMap.class));

        dbService.register(io.skysail.server.app.livingspec.storymap.StoryMap.class);
            
        dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.livingspec.userstory.UserStory.class));

        dbService.register(io.skysail.server.app.livingspec.userstory.UserStory.class);
            
    }

   /*
   	DesignerApplicationModel: LivingSpec, projectName=skysail.server.app.livingSpec, path=../
   	Entities: 
   	 * DesignerEntityModel: id='io.skysail.server.app.livingspec.storymap.StoryMap', isAggregate=true
   	   Fields:
   	    - DesignerFieldModel(name=title, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)
   	   Relations:
   	    - EntityRelation(name=userStorys, targetEntityModel=UserStory, type=ONE_TO_MANY)

   	 * DesignerEntityModel: id='io.skysail.server.app.livingspec.userstory.UserStory', isAggregate=false
   	   Fields:
   	    - DesignerFieldModel(name=title, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)
   	    - DesignerFieldModel(name=content, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)

   	Repositories: 
   	Repositories(repositories={})


   	---

   	io.skysail.server.app.livingspec.storymap.StoryMapio.skysail.server.app.livingspec.userstory.UserStory

   */
}