package view;

import controller.SpeiseController;
import controller.ZutatController;
import model.Speise;
import model.Zutat;

import java.util.List;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class ViewLayer {
    SpeiseController speiseController = new SpeiseController();
    ZutatController zutatController = new ZutatController();

    public void start(){
        System.out.println("--- MENU ---");
        System.out.println("1 - Add Zutat");
        System.out.println("2 - Remove Zutat");
        System.out.println("3 - See all Zutaten");
        System.out.println("4 - Add Speise");
        System.out.println("5 - Remove Speise");
        System.out.println("6 - See all Speisen");
        System.out.println("7 - Filtern nach einer Menge");
        System.out.println("8 - Gib einen Zutat und zeig alle Speisen mit diesem Zutat an");
        Scanner console = new Scanner(System.in);
        while(console.hasNextInt()){
            int choice = 0;
            try {
                choice = console.nextInt();
            }
            catch (Exception e){
                System.out.println("Error: Integer not found.");
            }
            if (choice == 0){
                System.out.println("Error found. Start the program again");
            }
            if(choice == 1){
                Zutat newZutat = new Zutat("", NULL, NULL);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me the attribute of the Zutat:");
                System.out.println("Name:");
                newZutat.setName(scanner.nextLine());

                System.out.println("Preis:");
                newZutat.setPreis(scanner.nextInt());

                System.out.println("How many?:");
                newZutat.setMenge(scanner.nextInt());

                zutatController.zutatRepository.add(newZutat);
                start();
            }
            if(choice == 2){
                Zutat newZutat = new Zutat("", NULL, NULL);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me the attribute of the Zutat you want to remove:");
                System.out.println("Name:");
                newZutat.setName(scanner.nextLine());

                System.out.println("Preis:");
                newZutat.setPreis(scanner.nextInt());

                System.out.println("How many?:");
                newZutat.setMenge(scanner.nextInt());

                zutatController.zutatRepository.delete(newZutat);
                start();
            }
            if(choice == 3){
                zutatController.zutatRepository.printAllZutaten();
                start();
            }
            if(choice == 4) {
                Speise newSpeise = new Speise(NULL, "");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me the attributes of the Speise");
                System.out.println("Id(only integers):");
                newSpeise.setId(scanner.nextInt());

                System.out.println("Name:");
                newSpeise.setName(scanner.nextLine());

                speiseController.speiseRepository.add(newSpeise);
                start();
            }
            if(choice == 5){
                Speise newSpeise = new Speise(NULL, "");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me the attributes of the Speise you want to delete");
                System.out.println("Id(only integers):");
                newSpeise.setId(scanner.nextInt());

                System.out.println("Name:");
                newSpeise.setName(scanner.nextLine());

                speiseController.speiseRepository.delete(newSpeise);
                start();
            }
            if(choice == 6){
                speiseController.speiseRepository.printAllSpeisen();
                start();
            }
            if(choice == 7){
                Scanner scanner = new Scanner(System.in);
                System.out.println("What Menge do you want to use?");
                System.out.println("Menge:");
                int newMenge = scanner.nextInt();
                List<Zutat> filteredZutatenMenge = zutatController.zutatRepository.filternNachMenge(newMenge);
                for(Zutat zutat: filteredZutatenMenge){
                    System.out.println(zutat.getName()+" "+zutat.getPreis()+" "+zutat.getMenge());
                }
                start();
            }
            if(choice == 8){
                Zutat newZutat = new Zutat("", NULL, NULL);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Give me the attribute of the Zutat you want to search:");
                System.out.println("Name:");
                newZutat.setName(scanner.nextLine());

                System.out.println("Preis:");
                newZutat.setPreis(scanner.nextInt());

                System.out.println("How many?:");
                newZutat.setMenge(scanner.nextInt());

                List<Speise> filteredSpeisen = speiseController.speiseRepository.anzeigenNachZutat(newZutat);
                for(Speise speise: filteredSpeisen){
                    System.out.println(speise.getId()+" "+speise.getName());
                    for(Zutat zutat: speise.getZutaten()){
                        System.out.println(zutat.getName()+" "+zutat.getPreis()+" "+ zutat.getMenge());
                    }
                }
                start();
            }
        }
    }
}
