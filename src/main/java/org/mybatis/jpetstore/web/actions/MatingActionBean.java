package org.mybatis.jpetstore.web.actions;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.integration.spring.SpringBean;
import org.mybatis.jpetstore.domain.Mating;
import org.mybatis.jpetstore.service.MatingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SessionScope
public class MatingActionBean extends AbstractActionBean{

    private static final String NEW_MATING = "/WEB-INF/jsp/mating/WriteMatingForm.jsp";
    private static final String LIST_MATING = "/WEB-INF/jsp/mating/ListMating.jsp";
    private static final String VIEW_MATING = "/WEB-INF/jsp/mating/ViewMating.jsp";
    private static final String CATEGORY_MATING = "/WEB-INF/jsp/mating/CategoryMating.jsp";
    private static final String EDIT_MATING = "/WEB-INF/jsp/mating/EditMatingForm.jsp";
    private static final String imagePath = "/jpetstore-6realfinal/jpetstore-6/src/main/webapp";

    private static final List<String> TYPE_LIST;

    @SpringBean
    private transient MatingService matingService;

    private Mating mating = new Mating();
    private int matingId;
    private String title;
    private String type;
    private String username;
    private String species;
    private String sex;
    private int age;
    private String content;
    private List<Mating> matingList;
    private String path;
    private FileBean fileBean;

    static {
        TYPE_LIST = Collections.unmodifiableList(Arrays.asList("DOGS", "REPTILES", "CATS", "BIRDS", "FISH"));
    }

    public Mating getMating() {
        return mating;
    }

    public void setMating(Mating mating) {
        this.mating = mating;
    }

    public int getMatingId() {
        return matingId;
    }

    public String getTitle() {
        return mating.getTitle();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMatingId(int matingId) {
        this.matingId = matingId;
    }

    public String getType(String type) {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTypes() {
        return TYPE_LIST;
    }

    public String getSpecies() {
        return mating.getSpecies();
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSex() {
        return mating.getSex();
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return mating.getAge();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContent() {
        return mating.getContent();
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return mating.getPath();
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<Mating> getMatingList() {
        return matingList;
    }

    public void setMatingList(List<Mating> matingList) {
        this.matingList = matingList;
    }

    public String getUsername() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");
        return accountBean.getUsername();
    }

    public void setUsername() { mating.setUsername(getUsername()); }

    public FileBean getFileBean() { return fileBean; }

    public void setFileBean(FileBean fileBean) { this.fileBean = fileBean; }

    /**
     * Category matiing.
     *
     * @return the resolution
     */
    public Resolution categoryMating() {
        return new ForwardResolution(CATEGORY_MATING);
    }


    /**
     * List matiing.
     *
     * @return the resolution
     */


    public ForwardResolution listMating() {
        if(type != null){
            matingList = matingService.getMatingList(type);
        }
        return new ForwardResolution(LIST_MATING);
    }

    /**
     * View matiing.
     *
     * @return the resolution
     */

    public Resolution viewMating() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        clear();

        if (accountBean == null ||!accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        } else {
            Integer val = matingId;
            System.out.println(matingId);
            if (val != null) {
                mating = matingService.getMating(matingId);
            }
            return new ForwardResolution(VIEW_MATING);
        }
    }

    /**
     * New write form.
     *
     * @return the resolution
     */

    public Resolution writeMatingForm() {
        HttpSession session = context.getRequest().getSession();
        AccountActionBean accountBean = (AccountActionBean) session.getAttribute("/actions/Account.action");

        clear();
        if (accountBean == null ||!accountBean.isAuthenticated()) {
            setMessage("Login First!");
            return new ForwardResolution(AccountActionBean.class);
        } else {
            return new ForwardResolution(NEW_MATING);
        }
    }
    /**
     * New matiing.
     *
     * @return the resolution
     */
    public Resolution newMating() {
        try {
            setUsername();
            if(mating.getTitle()==null|| mating.getSpecies()==null
                    ||mating.getContent()==null){
                setMessage("Please post and try checking your text.");
                return new ForwardResolution(NEW_MATING);
            }
            matingService.insertMating(mating);
            int last_insert = matingService.matingLastInsert();
            if (fileBean != null){
                fileBean.getContentType();
                fileBean.getSize();
                String tmp = "";
                tmp += "/images/post/";
                tmp += Integer.toString(last_insert);
                tmp += fileBean.getFileName();
                mating.setMatingId(last_insert);
                mating.setPath(tmp);
                matingService.insertPath(mating);
                fileBean.save(new File(imagePath + tmp));
            }

            matingList = matingService.getMatingList(type);
            return new ForwardResolution(LIST_MATING);
        }
        catch (IOException ex){
            matingList = matingService.getMatingList(type);
            return new ForwardResolution(LIST_MATING);
        }
    }

    public void clear() {
        mating = new Mating();
        matingList = null;
        fileBean = null;
    }

    /**
     * Delete matiing.
     *
     * @return the redirectResolution
     */
    public RedirectResolution delMating() {
        Integer val = matingId;
        if (val != null) {
            matingService.delMating(matingId);
        }
        return new RedirectResolution(MatingActionBean.class, "listMating")
                .addParameter("type", type);
    }

    /**
     * Edit matiing.
     *
     * @return the resolution
     */
    public Resolution editMatingForm() {
        return new ForwardResolution(EDIT_MATING);
    }

    public Resolution editMating() {
        matingService.editMating(mating);
        mating = matingService.getMating(mating.getMatingId());
        return new ForwardResolution(VIEW_MATING);
    }
}
