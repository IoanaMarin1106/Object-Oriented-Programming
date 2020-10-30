package tema3;

import java.util.*;
import java.io.*;

public class Test {
	final static String TASK1 = "inscriere";
	final static String TASK2 = "competitie";
	
	final static String FOOTBALL = "football";
	final static String BASKETBALL = "basketball";
	final static String HANDBALL = "handball";
	
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) {
		try {
			
			String task = args[0];
			
			/* Baza de date unde vor fi tinute toate echipele in functie de numele lor */
			AllTeams allTeams = AllTeams.getInstance();
			HashMap<String, Team> competition = new HashMap<String, Team>();
			
				
			String inputFileName = args[1];
			/* Args[2] este un string random -> trebuie ignorat */
				
			String[] commands = new String[4];
				
			Scanner input = new Scanner(inputFileName);
			File teamInput = new File(input.nextLine());
			input = new Scanner(teamInput);
			
				
			while (input.hasNextLine()) {
				String line = input.nextLine();
				
				commands = line.split(",");
				String teamName = commands[1];
				teamName = teamName.replaceFirst(" ", "");
					
				line = line.replaceAll("\\s","");
				commands = line.split("[, ]+");
					
				int numberOfPlayers = 0;
					
				switch(commands[0]) {
				case FOOTBALL:
					FootballTeam footballTeam = (FootballTeam) TeamFactory.getTeam(commands[0]);
					footballTeam.setTeamName(teamName);
					footballTeam.setGender(commands[2]);
						
					footballTeam.setNumberOfPlayers(Integer.parseInt(commands[3]));
						
					numberOfPlayers = Integer.parseInt(commands[3]);
						
					while(numberOfPlayers > 0) {
						line = input.nextLine().replaceAll("\\s","");
						commands = line.split(",");
							
						Player footballPlayer = new Player();
						footballPlayer.setName(commands[0]);
						footballPlayer.setScore(Integer.parseInt(commands[1]));
							
						footballTeam.getPlayers().add(footballPlayer);
						numberOfPlayers -= 1;	
					}
					
					allTeams.getTeamsNames().add(footballTeam.getTeamName());
					allTeams.put(footballTeam.getTeamName(), footballTeam);
					break;
						
				case BASKETBALL:
					BasketballTeam basketballTeam = (BasketballTeam) TeamFactory.getTeam(commands[0]);
						
					basketballTeam.setTeamName(teamName);
					basketballTeam.setGender(commands[2]);
					basketballTeam.setNumberOfPlayers(Integer.parseInt(commands[3]));
						
					numberOfPlayers = Integer.parseInt(commands[3]);
						
					while(numberOfPlayers > 0) {
						line = input.nextLine().replaceAll("\\s","");
						commands = line.split(",");
							
						Player basketballPlayer = new Player();
						basketballPlayer.setName(commands[0]);
						basketballPlayer.setScore(Integer.parseInt(commands[1]));
							
						basketballTeam.getPlayers().add(basketballPlayer);
							
						numberOfPlayers -= 1;	
					}
					
					allTeams.getTeamsNames().add(basketballTeam.getTeamName());
					allTeams.put(basketballTeam.getTeamName(), basketballTeam);
					break;
						
				case HANDBALL:
					HandballTeam handballTeam = (HandballTeam) TeamFactory.getTeam(commands[0]);
						
					handballTeam.setTeamName(commands[1]);
					handballTeam.setGender(commands[2]);
					handballTeam.setNumberOfPlayers(Integer.parseInt(commands[3]));
											
					numberOfPlayers = Integer.parseInt(commands[3]);
						
					while(numberOfPlayers > 0) {
						line = input.nextLine().replaceAll("\\s","");
						commands = line.split(",");
							
						Player handballPlayer = new Player();
						handballPlayer.setName(commands[0]);
						handballPlayer.setScore(Integer.parseInt(commands[1]));
							
						handballTeam.getPlayers().add(handballPlayer);
							
						numberOfPlayers -= 1;	
					}
					
					allTeams.getTeamsNames().add(handballTeam.getTeamName());
					allTeams.put(handballTeam.getTeamName(), handballTeam);
					break;
				}
			}
			
			if (task.equals(TASK1)) {
				String outputFileName = args[3];
				
				PrintWriter writer = new PrintWriter(new FileWriter(outputFileName));
				for (String teamName : allTeams.getTeamsNames()) {
					allTeams.getTeams().get(teamName).listTeam(writer);
				}
			
				writer.close();
				return;
			}
				
			if (task.equals(TASK2)) {
				
				String[] attributes = new String[2];
				String competitionFileName = args[2];
				String resultFileName = args[3];
				
				Scanner competitionInput = new Scanner(competitionFileName);
				File competitionFile = new File(competitionInput.nextLine());
				competitionInput = new Scanner(competitionFile);
				
				Competition tournament = Competition.getInstance();
				
				while(competitionInput.hasNextLine()) {
					
					String line = competitionInput.nextLine();
					attributes = line.split("[, ]");
				
					if(attributes.length != 1) {
						tournament.setType(attributes[0]);
						tournament.setGender(attributes[2]);
					} else if (attributes.length == 1){
						if (allTeams.getTeam(attributes[0]).checkTeam(tournament)) {
							tournament.getTeams().add(allTeams.getTeam(attributes[0]));
						}
					}	
				}			
				tournament.matches();
				
				PrintWriter writer = new PrintWriter(new FileWriter(resultFileName));
				tournament.listRaking(writer);
				writer.close();
				return;
			}	
			
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
