package CreateUrls.Models;

import javax.annotation.sql.DataSourceDefinition;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import org.slf4j.Logger;

/**
 * Created by Puja on 19/08/19.
 */


public class Diagram {



    public ArrayList<DiagramValue> getResult() {
		return result;
	}

	public void setResult(ArrayList<DiagramValue> result) {
		this.result = result;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	private ArrayList<DiagramValue> result;

    private Integer count;

    @Override
    public String toString() {
        return "Diagram{" +
                "result=" + result +
                ", count=" + count +
                '}';
    }
}
