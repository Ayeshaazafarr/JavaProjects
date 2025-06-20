package gamesystemm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class BatmanGameGUI extends JFrame {

    // UI Components
    private JTabbedPane tabs;
    private JList<String> weaponList, armorList, inventoryList;
    private DefaultListModel<String> inventoryModel;
    private JTextArea statsArea, outputArea;

    // Game Data
    private String playerName = "Batman";
    private int baseHealth = 100;
    private int baseDamage = 10;
    private int currentHealth = baseHealth;

    private String[] weapons = {"Batarang", "Grappling Gun", "Explosive Gel", "Batmobile Cannon", "Smoke Bomb"};
    private int[] weaponDamage = {20, 15, 30, 25, 10};
    private String[] getWeaponDisplayNames() {
        String[] displayNames = new String[weapons.length];
        for (int i = 0; i < weapons.length; i++) {
            displayNames[i] = weapons[i] + " (Damage: " + weaponDamage[i] + ")";
        }
        return displayNames;
    }

    private ArrayList<String> equippedWeapons = new ArrayList<>();

    private String[] armors = {"Cowl", "Gloves", "Chest Armor", "Leg Armor", "Boots"};
    private int[] armorDefense = {25, 15, 30, 20, 10};
    private String[] getArmorDisplayNames() {
        String[] displayNames = new String[armors.length];
        for (int i = 0; i < armors.length; i++) {
            displayNames[i] = armors[i] + " (Defense: " + armorDefense[i] + ")";
        }
        return displayNames;
    }

    private ArrayList<String> equippedArmor = new ArrayList<>();

    public BatmanGameGUI() {
        setTitle("Batman Game");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Dark Mode
        UIManager.put("control", new Color(50, 50, 50));
        UIManager.put("info", new Color(50, 50, 50));
        UIManager.put("nimbusBase", new Color(18, 30, 49));
        UIManager.put("nimbusAlertYellow", new Color(248, 187, 0));
        UIManager.put("nimbusDisabledText", new Color(128, 128, 128));
        UIManager.put("nimbusFocus", new Color(115, 164, 209));
        UIManager.put("nimbusGreen", new Color(176, 179, 50));
        UIManager.put("nimbusInfoBlue", new Color(66, 139, 221));
        UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
        UIManager.put("nimbusOrange", new Color(191, 98, 4));
        UIManager.put("nimbusRed", new Color(169, 46, 34));
        UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
        UIManager.put("nimbusSelectionBackground", new Color(104, 93, 156));
        UIManager.put("text", new Color(230, 230, 230));
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get player name
        String name = JOptionPane.showInputDialog(this, "Enter your Batman alias:");
        if (name != null && !name.trim().isEmpty()) {
            playerName = name.trim();
        }else {
            JOptionPane.showMessageDialog(this, "Alias cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        JOptionPane.showMessageDialog(this,
        	    "Welcome to the Batman Game!\n\n" +
        	    "Instructions:\n" +
        	    "- Equip weapons in the Weapons tab to increase your damage.\n" +
        	    "- Equip armor in the Armor tab to boost your total health.\n" +
        	    "- Use the Inventory tab to manage additional items.\n" +
        	    "- Go to the Stats tab and click 'Refresh Stats' to see your full stats.\n" +
        	    "- Head to the Battle tab to fight villains like Joker and Bane.\n" +
        	    "- You can reset your health if you're low after a battle.\n\n" +
        	    "Tip: Equip wisely before entering battles. Gotham depends on you!",
        	    "Instructions", JOptionPane.INFORMATION_MESSAGE);
        
        

        tabs = new JTabbedPane();
        add(tabs, BorderLayout.CENTER);

        setupWeaponsTab();
        setupArmorTab();
        setupInventoryTab();
        setupStatsTab();
        setupBattleTab();

        outputArea = new JTextArea(5, 50);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    private void setupWeaponsTab() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        weaponList = new JList<>(getWeaponDisplayNames());

        panel.add(new JScrollPane(weaponList), BorderLayout.CENTER);

        JButton equip = new JButton("Equip");
        JButton unequip = new JButton("Unequip");
        
        equip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = weaponList.getSelectedValue();
                if (selected != null) {
                    // Extract base weapon name before first " ("
                    String baseName = selected.split(" \\(")[0];
                    if (!equippedWeapons.contains(baseName)) {
                        equippedWeapons.add(baseName);
                        appendOutput("Equipped: " + baseName);
                        updateStats();
                    }
                }
            }
        });

        unequip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = weaponList.getSelectedValue();
                if (selected != null) {
                    String baseName = selected.split(" \\(")[0];  // Get base weapon name
                    if (equippedWeapons.contains(baseName)) {
                        equippedWeapons.remove(baseName);
                        appendOutput("Unequipped: " + baseName);
                        updateStats();
                    }
                }
            }
        });



        JPanel buttons = new JPanel();
        buttons.add(equip);
        buttons.add(unequip);
        panel.add(buttons, BorderLayout.SOUTH);

        tabs.add("Weapons", panel);
    }

    private void setupArmorTab() {
        JPanel panel = new JPanel(new BorderLayout());

        armorList = new JList<>(getArmorDisplayNames());

        panel.add(new JScrollPane(armorList), BorderLayout.CENTER);

        JButton equip = new JButton("Equip");
        JButton unequip = new JButton("Unequip");
        
        equip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = armorList.getSelectedValue();
                if (selected != null) {
                    String baseName = selected.split(" \\(")[0];  // Get base armor name
                    if (!equippedArmor.contains(baseName)) {
                        equippedArmor.add(baseName);
                        appendOutput("Equipped armor: " + baseName);
                        updateStats();
                    }
                }
            }
        });
        unequip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = armorList.getSelectedValue();
                if (selected != null) {
                    String baseName = selected.split(" \\(")[0];  // Get base armor name
                    if (equippedArmor.contains(baseName)) {
                        equippedArmor.remove(baseName);
                        appendOutput("Unequipped armor: " + baseName);
                        updateStats();
                    }
                }
            }
        });



        JPanel buttons = new JPanel();
        buttons.add(equip);
        buttons.add(unequip);
        panel.add(buttons, BorderLayout.SOUTH);

        tabs.add("Armor", panel);
    }

    private void setupInventoryTab() {
        JPanel panel = new JPanel(new BorderLayout());

        inventoryModel = new DefaultListModel<>();
        inventoryList = new JList<>(inventoryModel);
        panel.add(new JScrollPane(inventoryList), BorderLayout.CENTER);

        JButton add = new JButton("Add");
        JButton remove = new JButton("Remove");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = JOptionPane.showInputDialog(BatmanGameGUI.this, "Enter item name:");
                if (item != null && !item.trim().isEmpty()) {
                    inventoryModel.addElement(item.trim());
                    appendOutput("Added to inventory: " + item.trim());
                }
            }
        });
        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selected = inventoryList.getSelectedValue();
                if (selected != null) {
                    inventoryModel.removeElement(selected);
                    appendOutput("Removed from inventory: " + selected);
                }
            }
        });


        JPanel buttons = new JPanel();
        buttons.add(add);
        buttons.add(remove);
        panel.add(buttons, BorderLayout.SOUTH);

        tabs.add("Inventory", panel);
    }

  
    private void setupStatsTab() {
        JPanel panel = new JPanel(new BorderLayout());
        statsArea = new JTextArea();
        statsArea.setEditable(false);
        panel.add(new JScrollPane(statsArea), BorderLayout.CENTER);

        JButton refresh = new JButton("Refresh Stats");
        JButton save = new JButton("Save Game");
        JButton load = new JButton("Load Game");

        refresh.addActionListener(e -> updateStats());
        save.addActionListener(e -> saveGame());
        load.addActionListener(e -> loadGame());

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(save);
        buttons.add(load);
        panel.add(buttons, BorderLayout.SOUTH);

        tabs.add("Stats", panel);
    }


      

    private void updateStats() {
        int totalDamage = baseDamage;
        int totalHealth = baseHealth;

        for (String w : equippedWeapons) {
            int i = Arrays.asList(weapons).indexOf(w);
            if (i >= 0) totalDamage += weaponDamage[i];
        }
        for (String a : equippedArmor) {
            int i = Arrays.asList(armors).indexOf(a);
            if (i >= 0) totalHealth += armorDefense[i];
        }

        statsArea.setText("Player: " + playerName +
                "\nBase Damage: " + baseDamage +
                "\nBase Health: " + baseHealth +
                "\nEquipped Weapons: " + equippedWeapons +
                "\nEquipped Armor: " + equippedArmor +
                "\nTotal Damage: " + totalDamage +
                "\nTotal Health: " + totalHealth);
    }

    private void startBattle(String enemy, int enemyHealth, int enemyDamage) {
        int playerHealth = currentHealth;
        int totalDamage = baseDamage;

        for (String w : equippedWeapons) {
            int i = Arrays.asList(weapons).indexOf(w);
            if (i >= 0) totalDamage += weaponDamage[i];
        }

        for (String a : equippedArmor) {
            int i = Arrays.asList(armors).indexOf(a);
            if (i >= 0) playerHealth += armorDefense[i];
        }

        appendOutput("Battle started with " + enemy);

        while (playerHealth > 0 && enemyHealth > 0) {
            enemyHealth -= totalDamage;
            appendOutput(playerName + " hits " + enemy + " for " + totalDamage);
            if (enemyHealth <= 0) {
                appendOutput("You defeated " + enemy);
                break;
            }
            playerHealth -= enemyDamage;
            appendOutput(enemy + " hits back for " + enemyDamage);
            if (playerHealth <= 0) {
                appendOutput(playerName + " has fallen...");
                break;
            }
            int option = JOptionPane.showConfirmDialog(this,
                    playerName + ": " + playerHealth + " HP\n" +
                            enemy + ": " + enemyHealth + " HP\n\nContinue?",
                    "Continue Battle", JOptionPane.YES_NO_OPTION);
            if (option != JOptionPane.YES_OPTION) {
                appendOutput("You escaped the battle.");
                break;
            }
        }
        currentHealth = Math.max(0, playerHealth);
    }
    private void setupBattleTab() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextArea battleLog = new JTextArea();
        battleLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(battleLog);

        JPanel buttonPanel = new JPanel();

        JButton fightJoker = new JButton("Fight Joker");
        fightJoker.addActionListener(e -> {
            battleLog.append("Starting battle with Joker...\n");
            startBattle("Joker", 80, 15);
            battleLog.append("Battle ended.\n\n");
        });

        JButton fightBane = new JButton("Fight Bane");
        fightBane.addActionListener(e -> {
            battleLog.append("Starting battle with Bane...\n");
            startBattle("Bane", 120, 25);
            battleLog.append("Battle ended.\n\n");
        });

        JButton resetHealth = new JButton("Reset Health");
        resetHealth.addActionListener(e -> {
            currentHealth = baseHealth;
            battleLog.append("Health reset to base: " + baseHealth + "\n");
        });

        buttonPanel.add(fightJoker);
        buttonPanel.add(fightBane);
        buttonPanel.add(resetHealth);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        tabs.add("Battle", panel);
    }

    private void appendOutput(String msg) {
        outputArea.append(msg + "\n");
    }
    private void saveGame() {
        File file = new File("savegame.txt");  // fixed filename
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            writer.println(playerName);
            writer.println(currentHealth);
            writer.println(String.join(",", equippedWeapons));
            writer.println(String.join(",", equippedArmor));
            for (int i = 0; i < inventoryModel.size(); i++) {
                writer.println("ITEM:" + inventoryModel.getElementAt(i));
            }
            appendOutput("Game saved to " + file.getName());
        } catch (IOException ex) {
            appendOutput("Error saving game: " + ex.getMessage());
        }
    }

    private void loadGame() {
        File file = new File("savegame.txt");  // fixed filename
        if (!file.exists()) {
            appendOutput("Save file not found.");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            playerName = reader.readLine();
            currentHealth = Integer.parseInt(reader.readLine());

            equippedWeapons.clear();
            String[] weaponsArray = reader.readLine().split(",");
            if (weaponsArray.length > 0 && !weaponsArray[0].isEmpty()) {
                equippedWeapons.addAll(Arrays.asList(weaponsArray));
            }

            equippedArmor.clear();
            String[] armorArray = reader.readLine().split(",");
            if (armorArray.length > 0 && !armorArray[0].isEmpty()) {
                equippedArmor.addAll(Arrays.asList(armorArray));
            }

            inventoryModel.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("ITEM:")) {
                    inventoryModel.addElement(line.substring(5));
                }
            }

            appendOutput("Game loaded from " + file.getName());
            updateStats();
        } catch (IOException | NumberFormatException ex) {
            appendOutput("Error loading game: " + ex.getMessage());
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BatmanGameGUI().setVisible(true));
    }
}