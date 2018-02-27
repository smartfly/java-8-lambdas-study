package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: hutao01
 * Date: 2018/2/7
 * Time: 15:17
 * Description: 创作音乐的个人或者团体
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public final class Artist {
    /**
     * 艺术家的名字
     */
    private String name;

    /**
     * 乐队成员
     */
    private List<Artist> members;

    /**
     * 乐队来自哪里
     */
    private String nationality;

    public Artist(String name, String nationality){
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality){
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return artists
     */
    public Stream<Artist> getMembers() {
        return members.stream();
    }

    /**
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * is solo ?
     * @return
     */
    public boolean isSolo(){
        return members.isEmpty();
    }

    /**
     * is nationality
     * @param nationality
     * @return
     */
    public boolean isFrom(String nationality){
        return this.nationality.equals(nationality);
    }

    @Override
    public String toString() {
        return getName();
    }

    public Artist copy(){
        List<Artist> members = getMembers()
                .map(Artist::copy)
                .collect(Collectors.toList());
        return new Artist(name, members, nationality);
    }
}
