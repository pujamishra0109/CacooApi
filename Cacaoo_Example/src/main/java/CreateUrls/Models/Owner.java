package CreateUrls.Models;

import lombok.Data;

/**
 * Created by Puja on 19/08/19.
 */

@Data
public class Owner {

    String name;
    String nickname;
    String type;

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", type='" + type + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    String imageUrl;



}
