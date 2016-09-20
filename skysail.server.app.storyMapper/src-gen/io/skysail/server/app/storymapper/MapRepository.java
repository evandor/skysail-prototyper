package io.skysail.server.app.storymapper;


import org.osgi.service.component.annotations.*;

import io.skysail.domain.core.repos.DbRepository;
import io.skysail.server.db.*;

/**
 * generated from repository.stg
 */
@Component(immediate = true, property = "name=MapsRepository")
public class MapRepository extends GraphDbRepository<io.skysail.server.app.storymapper.map.Map> implements DbRepository {

    @Reference
    public void setDbService(DbService dbService) {
        this.dbService = dbService;
    }

    public void unsetDbService(DbService dbService) {
        this.dbService = null;
    }

    @Activate
    public void activate() {
        //log.debug("activating io.skysail.server.app.storymapper.map.Map" Repository);
        //dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.storymapper.map.Map.class));
        //dbService.register(io.skysail.server.app.storymapper.map.Map.class);
        dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.storymapper.map.Map.class));

        dbService.register(io.skysail.server.app.storymapper.map.Map.class);
            
        dbService.createWithSuperClass("V", DbClassName.of(io.skysail.server.app.storymapper.story.Story.class));

        dbService.register(io.skysail.server.app.storymapper.story.Story.class);
            
    }

   /*
   	DesignerApplicationModel: StoryMapper, projectName=skysail.server.app.storyMapper, path=../
   	Entities: 
   	 * DesignerEntityModel: id='io.skysail.server.app.storymapper.map.Map', isAggregate=true
   	   Fields:
   	    - DesignerFieldModel(name=name, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)
   	   Relations:
   	    - EntityRelation(name=storys, targetEntityModel=Story, type=ONE_TO_MANY)

   	 * DesignerEntityModel: id='io.skysail.server.app.storymapper.story.Story', isAggregate=false
   	   Fields:
   	    - DesignerFieldModel(name=title, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)
   	    - DesignerFieldModel(name=story, listViewVisibility=SHOW, postViewVisibility=SHOW, putViewVisibility=SHOW, role=NONE)

   	Repositories: 
   	Repositories(repositories={})


   	---

   	io.skysail.server.app.storymapper.map.Mapio.skysail.server.app.storymapper.story.Story

   */
}