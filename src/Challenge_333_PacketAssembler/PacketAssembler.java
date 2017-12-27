package Challenge_333_PacketAssembler;

import java.util.ArrayList;
import java.util.Scanner;

public class PacketAssembler {

    /** Packets ArrayList that holds all messages & their values */
    static ArrayList<ArrayList<String>> packets = new ArrayList<>();

    public static void main(String[] args) {
        /** Example taken from Reddit post */
        /*
            7469    1   7   believe. Attack ships on fire off the
            9949    6   10  He's a silent guardian.
            2997    9   19  Force is a pathway to many abilities some
            6450    2   11  is a vestige of the vox populi, now vacant, vanished. However, this valorous
            6450    10  11
            6450    8   11  veers most verbose, so let me simply add that it's my very good honour to meet
            6450    5   11  and voracious violation of volition! The only verdict is vengeance; a vendetta
            9949    1   10  Because he's the hero Gotham deserves,
            6450    1   11  and villain by the vicissitudes of fate. This visage, no mere veneer of vanity,
            2997    13  19  he did. Unfortunately, he taught his
            9949    8   10  A Dark Knight.
            1938    4   17  by the iniquities of the selfish and the
            1938    0   17  You read the Bible, Brett? Well there's
            2997    0   19  Did you ever hear the tragedy of Darth
            2997    1   19  Plagueis the Wise? I thought not. It's not a
            1938    8   17  of darkness, for he is truly is brother's
            2997    14  19  apprentice everything he knew, then his
            6450    3   11  visitation of a bygone vexation stands vivified, and has vowed to vanquish these
            1938    12  17  who attempt to poison and destroy my
            6450    9   11  you and you may call me V.
            7469    2   7   shoulder of Orion. I watched C-beams
            2997    10  19  consider to be unnatural. He became so
            1938    1   17  this passage I got memorized, sorta fits
            2997    5   19  Force to influence the midichlorians to
            1938    6   17  in the name of charity and good will,
            7469    0   7   I've seen things you people wouldn't
            9949    4   10  Because he can take it.
            6450    7   11  vindicate the vigilant and the virtuous. Verily, this vichyssoise of verbiage
            9949    0   10  We have to chase him.
            9949    7   10  A watchful protector.
            2997    3   19  legend. Darth Plagueis was a Dark Lord of the
            6450    6   11  held as a votive, not in vain, for the value and veracity of such shall one day
            2997    8   19  cared about from dying. The dark side of the
            1938    10  17  And I will strike down upon thee with
            1938    11  17  great vengeance and furious anger those
            1938    7   17  shepherds the weak through the valley
            1938    2   17  this occasion. Ezekiel 25:17? "The path
            2997    18  19
            9949    9   10
            1938    14  17  the Lord when I lay my vengeance upon
            1938    15  17  thee."
            1938    9   17  keeper and the finder of lost children.
            1938    13  17  brothers. And you will know my name is
            9949    2   10  but not the one it needs right now.
            2997    16  19  he could have others from death, but not
            2997    7   19  dark side that he could even keep the once he
            1938    5   17  tyranny of evil men. Blessed is he who,
            2997    17  19  himself.
            2997    6   19  create life...He had such a knowledge of the
            2997    12  19  losing his power. Which eventually, of course,
            7469    4   7   Gate. All those moments will be lost
            2997    2   19  story the Jedi would tell you. It's a Sith
            1938    16  17
            2997    4   19  Sith so powerful and so wise, he could use the
            1938    3   17  of the righteous man is beset on all sides
            2997    11  19  powerful...The only thing he was afraid of was
            7469    6   7
            2997    15  19  apprentice killed him in his sleep. Ironic,
            7469    5   7   in time, like tears in rain. Time to die.
            9949    3   10  So we'll hunt him.
            7469    3   7   glitter in the dark near the Tannhäuser
            6450    4   11  venal and virulent vermin vanguarding vice and vouchsafing the violently vicious
            6450    0   11  Voilà! In view, a humble vaudevillian veteran, cast vicariously as both victim
            9949    5   10  Because he's not a hero.
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("Packet Assembler #333");
        while (true) {
            System.out.print("Packet: ");
            String input = sc.nextLine();
            assemble(input);
            System.out.println(packetsToString());
        }

    }

    /**
     * If packets is empty, a new ArrayList is added to packets with the input inside
     * Goes through packets and searches message ID's (X) - if a match is found it adds the input to that particular ArrayList
     * in the correct position by comparing packet ID's (Y)
     * Adds the input to a new ArrayList if no matching packet ID was found
     */
    static boolean assemble(String input) {
        if (packets.isEmpty()) {
            ArrayList<String> data = new ArrayList<>();
            data.add(input);
            packets.add(data);
            return true;
        }
        for (int i = 0; i < packets.size(); i++) {
            if (packets.get(i).get(0).substring(0, 8).replaceAll(" ", "").equals(input.substring(0, 8).replaceAll(" ", ""))) {
                for (int j = 0; j < packets.get(i).size(); j++) {
                    if (Integer.parseInt(input.substring(8, 12).replaceAll(" ", "")) < Integer.parseInt(packets.get(i).get(j).substring(8, 12).replaceAll(" ", ""))) {
                        packets.get(i).add(j, input);
                        rearrangePackets(i);
                        return true;
                    }
                }
                packets.get(i).add(input);
                rearrangePackets(i);
                return true;
            }
        }
        ArrayList<String> data = new ArrayList<>();
        data.add(input);
        packets.add(data);
        return true;
    }

    /**
     * Re-arranges the order of the ArrayLists inside packets
     * @param index The index value that has just been updated and needs to be last inside packets
     */
    static void rearrangePackets(int index) {
        ArrayList<ArrayList<String>> newPackets = new ArrayList<>();
        for (int i = 0; i < packets.size(); i++) {
            if (i == index) continue;
            newPackets.add(packets.get(i));
        }
        newPackets.add(packets.get(index));
        packets = newPackets;
    }

    /**
     * toString method for the packets ArrayList
     * @return StringBuilder toString
     */
    static String packetsToString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < packets.size(); i++) {
            for (int j = 0; j < packets.get(i).size(); j++) {
                sb.append(packets.get(i).get(j)).append("\n");
            }
        }
        return sb.toString();
    }

}
