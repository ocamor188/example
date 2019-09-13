import com.sixt.platform.interview.Functions;
import com.sixt.platform.interview.VulnerabilityScript;
import com.sixt.platform.interview.VulnerabilityScriptRun;
import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) {
        Functions functions = new Functions();
        System.out.println("-----------------------------------------");
        System.out.println(functions.isAnagram("Mother In Law", "Hitler Woman"));
        System.out.println(functions.isAnagram("keEp", "peeK"));
        System.out.println(functions.isAnagram("SiLeNt CAT", "LisTen AcT"));
        System.out.println(functions.isAnagram("Debit Card", "Bad Credit"));
        System.out.println(functions.isAnagram("School MASTER", "The ClassROOM"));
        System.out.println(functions.isAnagram("DORMITORY", "Dirty Room"));
        System.out.println(functions.isAnagram("ASTRONOMERS", "NO MORE STARS"));
        System.out.println(functions.isAnagram("Toss", "Shot"));
        System.out.println(functions.isAnagram("joy", "enjoy"));
        System.out.println(functions.isAnagram("anagram", "nagaram"));


        System.out.println("-----------------------------------------");
        System.out.println(functions.areAnagrams("Mother In Law", "Hitler Woman"));
        System.out.println(functions.areAnagrams("keEp", "peeK"));
        System.out.println(functions.areAnagrams("SiLeNt CAT", "LisTen AcT"));
        System.out.println(functions.areAnagrams("Debit Card", "Bad Credit"));
        System.out.println(functions.areAnagrams("School MASTER", "The ClassROOM"));
        System.out.println(functions.areAnagrams("DORMITORY", "Dirty Room"));
        System.out.println(functions.areAnagrams("ASTRONOMERS", "NO MORE STARS"));
        System.out.println(functions.areAnagrams("Toss", "Shot"));
        System.out.println(functions.areAnagrams("joy", "enjoy"));
        System.out.println(functions.areAnagrams("anagram", "nagaram"));
        System.out.println("-----------------------------------------");
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        Iterator<Integer> nextFromDB = new Iterators.Array<>(numbers);

        List<Integer> dependencies = new ArrayList<>();
        dependencies.add(1);
        dependencies.add(2);
        dependencies.add(3);
        dependencies.add(4);

        List<Integer> dependencies2 = new ArrayList<>();
        dependencies2.add(1);
        dependencies2.add(2);
        dependencies2.add(3);
        dependencies2.add(4);


        VulnerabilityScript script = new VulnerabilityScript(1, dependencies);
        VulnerabilityScript script21 = new VulnerabilityScript(2, dependencies2);

        Map<Integer, VulnerabilityScript> dbs = new HashMap<>();
        dbs.put(1, script);
        dbs.put(2, script21);


        VulnerabilityScriptRun scriptRun = new VulnerabilityScriptRun();

   /*     final VulnerabilityScript script1 = new VulnerabilityScript(1, Collections.singletonList(6));
        final VulnerabilityScript script2 = new VulnerabilityScript(2, Collections.singletonList(1));
        final VulnerabilityScript script3 = new VulnerabilityScript(3, Arrays.asList(1, 5));
        final VulnerabilityScript script4 = new VulnerabilityScript(4, Arrays.asList(1, 2));
        final VulnerabilityScript script5 = new VulnerabilityScript(5, Arrays.asList(2, 4));
        final VulnerabilityScript script6 = new VulnerabilityScript(6, new ArrayList<>());
        final Map<Integer, VulnerabilityScript> db = Stream.of(script1, script2, script3, script4, script5, script6)
                .collect(Collectors.toMap(VulnerabilityScript::getScriptId, Function.identity()));
        final List<Integer> scriptIdIterator = db.values().stream().map(VulnerabilityScript::getScriptId).collect(Collectors.toList());
        final Iterator<Integer> scriptIdIteratorIT = db.values().stream().map(VulnerabilityScript::getScriptId).collect(Collectors.toList()).iterator();

        scriptRun.processingScripts(scriptIdIteratorIT, db);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addAll(scriptIdIterator);
        //scriptRun.processingScripts(scriptIdIterator, db);
        scriptRun.processingScript(linkedList, db);
//        scriptRun.processingScript(nextFromDB, db);*/

    }
}
