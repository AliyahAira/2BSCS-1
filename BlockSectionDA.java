import java.util.*;
import java.io.*;

public class BlockSectionDA {
    private List <BlockSection> blockSectionList;


    //set getter 
    public List<BlockSection> getBlockSectionList(){
        return blockSectionList;
    }

    //create constructor - set initial actions of an object
    public BlockSectionDA() throws FileNotFoundException {

        blockSectionList = new ArrayList<>();


        Scanner blockFile = new Scanner (new FileReader("BlockFile.csv"));

        while(blockFile.hasNext()){
            BlockSection blocksection = new BlockSection();

            String blockSectionRaw = blockFile.nextLine();
            String[] blockSectionArray = new String[2];
            blockSectionArray = blockSectionRaw.split(",");

            //set the values for the blockSection object
            blocksection.setBlockCode(blockSectionArray[0].trim());
            blocksection.setAdviser(blockSectionArray[1].trim());

            StudentDA studentDA = new StudentDA(blocksection.getBlockCode());
            blocksection.setStudentList(studentDA.getStudentList());

            blockSectionList.add(blocksection);


        }



    }


}
