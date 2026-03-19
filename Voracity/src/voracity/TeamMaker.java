package voracity;

import java.util.ArrayList;

public class TeamMaker {
    private int numberOfTeams;
    private int maxValue;
    private Players players;
    private ArrayList<Team> teams;

    public int getMaxValue() {
        return maxValue;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public Players getPlayers() {
        return players;
    }

    public TeamMaker(int numberOfTeams, int maxValue, Players players) {
        this.numberOfTeams = numberOfTeams;
        this.maxValue = maxValue;
        this.players = players;

        this.teams = new ArrayList<Team>();

        for (int idx = 1; idx <= this.getNumberOfTeams(); idx++) {
            Team team = new Team("Equipo número " + idx, this.getMaxValue());
            this.teams.add(team);
        }
    }

    public void print()
    {
        for (Team team : this.teams) {
            team.print();
        }
    }

    public void makeTeamsMode1(){
        //Generar equipos contemplando únicamente no sobrepasar el valor máximo
        int equiposRecorridos =0;
        Players jugadores= this.getPlayers();
        
        jugadores.sortByPoints(); //ordena los jugadores por valor
        while(equiposRecorridos < this.getNumberOfTeams()){ 
            for(Team miEquipo : this.teams){
                Player miJugador= jugadores.getFirstPlayer(miEquipo.getBudget()); // compara que el valor del jugador no sea mayor que el presupuesto
                if(miJugador !=null){ //si el valor no supera el presupuesto maximo
                    miEquipo.setBudget(miEquipo.getBudget() - miJugador.getValue()); //resta el precio del jugador a nuestro presupuesto maximo
                    miEquipo.addPlayer(miJugador); //añade jugador al equipo
                    jugadores.removePlayer(miJugador); // elimina al jugador de la lista general de jugadores
                }else{
                    equiposRecorridos++; //cuando se  agota el presupuesto maximo cambiamos de equipo
                }
            }
        }
    }

    public void makeTeamsMode2(int minNumberOfPlayersPerTeam) {
        //Generar equipos contemplando:
        //  - no sobrepasar el valor máximo
        //  - que al menos haya minNumberOfPlayersPerTeam jugadores por equipo
        int equiposRecorridos =0;
        Players jugadores= this.getPlayers();
        jugadores.sortByName();//ordena los jugadores por orden alfabetico
        while(equiposRecorridos < this.getNumberOfTeams()){
            for(Team miEquipo : this.teams){    
                for(int numeroJugadores=0; numeroJugadores < minNumberOfPlayersPerTeam; numeroJugadores++){ //hasta que el numero de jugadores no supere el minimo de jugadores
                    Player miJugador= jugadores.getFirstPlayer(miEquipo.getBudget());
                    if(miJugador !=null){//si el valor no supera el presupuesto maximo
                        miEquipo.setBudget(miEquipo.getBudget() - miJugador.getValue()); //resta el precio del jugador a nuestro presupuesto maximo
                        miEquipo.addPlayer(miJugador); //añade jugador al equipo
                        jugadores.removePlayer(miJugador); // elimina al jugador de la lista general de jugadores
                    }
                }
                while(miEquipo.getBudget() > 0 && jugadores.getFirstPlayer(miEquipo.getBudget()) != null){ //mientras el presupuesto sea mayor que cero y el precio del jugador no supere el presupuesto restante
                    Player miJugador= jugadores.getFirstPlayer(miEquipo.getBudget()); //compara que el valor del jugador no sea mayor que el presupuesto
                    miEquipo.setBudget(miEquipo.getBudget() - miJugador.getValue()); //resta el precio del jugador a nuestro presupuesto maximo
                    miEquipo.addPlayer(miJugador);//añade jugador al equipo
                    jugadores.removePlayer(miJugador);// elimina al jugador de la lista general de jugadores
                }
                equiposRecorridos++; //cuando se nos agota el presupuesto maximo se pasa al siguiente equipo
            }
        }
    }  
}
