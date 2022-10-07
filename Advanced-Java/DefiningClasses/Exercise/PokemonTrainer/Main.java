package DefiningClasses.Exercise.PokemonTrainer;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Tournament")) {
            String trainerName = input.split(" ")[0];
            String pokemonName = input.split(" ")[1];
            String pokemonElement = input.split(" ")[2];
            int pokemonHealth = Integer.parseInt(input.split(" ")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName, new ArrayList<>()));
            trainers.get(trainerName).getPokemonList().add(pokemon);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            String element = input;

            for (Trainer trainer : trainers.values()) {
                boolean isFound = false;

                for (Pokemon pokemon : trainer.getPokemonList()) {
                    if (pokemon.getElement().equals(element)) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    trainer.addBadge();
                } else {
                    for (Pokemon pokemon : trainer.getPokemonList()) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                    }
                    trainer.getPokemonList().removeIf(p -> p.getHealth() <= 0);
                }
            }
            input = scanner.nextLine();
        }
        Map<String, Trainer> sorted = trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumberOfBadges(), b1.getValue().getNumberOfBadges()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new
                ));

        sorted.forEach((key, value) -> System.out.printf("%s %d %d%n", key, value.getNumberOfBadges(), value.getPokemonList().size()));
    }
}
