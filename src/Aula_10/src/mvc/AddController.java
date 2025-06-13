package src.mvc;

public class AddController implements Controller {

    View view;
    LeagueStatsModel model;

    public AddController(LeagueStatsModel theModel) {
        view = new AddView(this, theModel);
        model = theModel;
        view.show();
    }

    // Aqui você implementa o método para adicionar resultado ao modelo
    public void addMatchResult(String team1, int goals1, String team2, int goals2) {
        model.addMatchResult(team1, goals1, team2, goals2);
    }
}
