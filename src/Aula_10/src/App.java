package src;

import src.mvc.*;

public class App {
    public static void main(String[] args) {
        LeagueStatsModel model = new LeagueStatsModel();
        model.populate(); // cria dados iniciais

        TableController tableController = new TableController(model);
        TableView tableView = new TableView(tableController, model);
        tableView.createView();
        tableView.show();

        AddController addController = new AddController(model);
        AddView addView = new AddView(addController, model);
        addView.createView();
        addView.show();
    }
}
