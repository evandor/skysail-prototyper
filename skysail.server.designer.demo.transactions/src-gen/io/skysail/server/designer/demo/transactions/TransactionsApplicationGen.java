package io.skysail.server.designer.demo.transactions;

import java.util.List;

import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.event.EventAdmin;

import io.skysail.domain.Identifiable;
import io.skysail.domain.core.Repositories;
import io.skysail.server.app.ApiVersion;
import io.skysail.server.app.ApplicationProvider;
import io.skysail.server.app.SkysailApplication;
import io.skysail.server.designer.demo.transactions.transaction.resources.PostTransactionResourceGen;
import io.skysail.server.designer.demo.transactions.transaction.resources.PutTransactionResourceGen;
import io.skysail.server.designer.demo.transactions.transaction.resources.TransactionResourceGen;
import io.skysail.server.designer.demo.transactions.transaction.resources.TransactionsResourceGen;
import io.skysail.server.menus.MenuItemProvider;
import io.skysail.server.restlet.RouteBuilder;


/**
 * generated from application.stg
 */
public class TransactionsApplicationGen extends SkysailApplication implements ApplicationProvider, MenuItemProvider {

    public static final String LIST_ID = "lid";
    public static final String TODO_ID = "id";
    public static final String APP_NAME = "Transactions";

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private volatile EventAdmin eventAdmin;

    public TransactionsApplicationGen(String name, ApiVersion apiVersion, List<Class<? extends Identifiable>>  entityClasses) {
        super(name, apiVersion, entityClasses);
    }

    @Reference(policy = ReferencePolicy.DYNAMIC, cardinality = ReferenceCardinality.MANDATORY)
    public void setRepositories(Repositories repos) {
        super.setRepositories(repos);
    }

    public void unsetRepositories(Repositories repo) {
        super.setRepositories(null);
    }



    @Override
    protected void attach() {
        super.attach();
        router.attach(new RouteBuilder("/Transactions/{id}", TransactionResourceGen.class));
        router.attach(new RouteBuilder("/Transactions/", PostTransactionResourceGen.class));
        router.attach(new RouteBuilder("/Transactions/{id}/", PutTransactionResourceGen.class));
        router.attach(new RouteBuilder("/Transactions", TransactionsResourceGen.class));
        router.attach(new RouteBuilder("", io.skysail.server.designer.demo.transactions.transaction.resources.TransactionsResourceGen.class));

    }

    public EventAdmin getEventAdmin() {
        return eventAdmin;
    }

}