package CreateUrls.Models;

import javax.annotation.sql.DataSourceDefinition;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.slf4j.Logger;

/**
 * Created by Puja on 19/08/19.
 */
@Data
public class Diagram {



    ArrayList<DiagramValue> result;

    Integer count;

    @Override
    public String toString() {
        return "Diagram{" +
                "result=" + result +
                ", count=" + count +
                '}';
    }
}
