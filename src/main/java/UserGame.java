import chariot.Client;
import chariot.model.Game;
import chariot.model.Result;


import net.dv8tion.jda.api.EmbedBuilder;



public class UserGame {

    private EmbedBuilder embedBuilder;
    private Client client;
    private String getUserID;
    private String gameID;

    public UserGame(Client client, String userID){
        this.client = client;
        this.getUserID = userID;
    }


    public String getUserGames(){

        this.embedBuilder = new EmbedBuilder();
        String gameGifs = "";

        Result<Game> getGame = this.client.games().byUserId(this.getUserID);
        if(getGame.isPresent()){



            gameGifs += "https://lichess1.org/game/export/gif/" + getGame.get().id() + ".gif";


        }else{
           return gameGifs;
        }



       return gameGifs;

    }

    public String getGameId(){
        Result<Game> getGameID = this.client.games().byUserId(this.getUserID);
        this.gameID = getGameID.get().id();

        return this.gameID;
    }

    public String getUserID(){
        return this.getUserID;
    }

    public Client getClient(){
        return this.client;
    }


}
