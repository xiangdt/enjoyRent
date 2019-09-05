package com.newer.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newer.domain.User;
import com.newer.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.naming.SizeLimitExceededException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Iterator;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        try {
        if ("addUser".equals(action)){
                addUser(req,resp);
        }else if (action==null){
            addimg(req,resp);
        }else if ("".equals(action)){
            findAll(req,resp);
        }else if("findByUsername".equals(action)){
            findByUsername(req,resp);
        }
        } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    }

    private void findByUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        int row=userService.findByUsername(username);
        PrintWriter out=resp.getWriter();
        out.print(row);
    }

    private void findAll(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        List<User> list=userService.findAll();
        Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd hh-mm-ss").create();
        PrintWriter out=resp.getWriter();
        out.print(gson.toJson(list));
        out.close();
    }
    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        User user=new User();
        BeanUtils.populate(user,req.getParameterMap());
        int rows=userService.addUser(user);
        PrintWriter out=resp.getWriter();
        out.print(rows);
        out.close();
    }
    private void addimg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username=req.getParameter("username");
        String choice=req.getParameter("choice");
        User user=userService.findByname(username);

        //设置上传文件大小上限
        final long maxSize=5*1024*1024;
        //允许上传文件的格式
        final String[] allowedExt=new String[]{"jpg","png","gif"};
        //实例化一个硬盘工厂，来配置上传组件
        DiskFileItemFactory dfif=new DiskFileItemFactory();
        //设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘
        dfif.setSizeThreshold(4096);
        //置存放临时文件的目录,web根目录下的uploadfile目录
        File file=new File(this.getServletContext().getRealPath("Auditing"));
        if (!file.exists()&&!file.isDirectory()){
            file.mkdir();
            System.out.println("不存在");
        }
        dfif.setRepository(file);
        //用以上工厂实例化上传组件
        ServletFileUpload servletFileUpload=new ServletFileUpload(dfif);
        //设置最大上传尺寸
        servletFileUpload.setFileSizeMax(maxSize);
        PrintWriter out = resp.getWriter();
        //从request得到所有上传域的列表
        List fileList=null;
        try {
            fileList=servletFileUpload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //没有文件上传
        if (fileList==null||fileList.size()==0){
            out.print("未选择上传文件");
            return;
        }
        //得到所有上传的文件
        Iterator fileItr=fileList.iterator();
        //循环处理所有文件
        while (fileItr.hasNext()){
            FileItem fileItem=null;
            String path=null;
            long size =0;
            //得到当前文件
            fileItem=(FileItem) fileItr.next();
            //忽略from字段而不是上传域的文件域（<input type="text"/>）
            if (fileItem==null||fileItem.isFormField()){
                continue;
            }
            //得到文件的完整路径
            path=fileItem.getName();
            //得到文件的大小
            size=fileItem.getSize();
            if ("".equals(path)||size==0){
                out.print("未选择上传文件");
                return;
            }
            //得到去除路径的文件名
            String t_name=path.substring(path.lastIndexOf("\\")+1);
            //得到文件的扩展名
            String t_ext=t_name.substring(t_name.lastIndexOf(".")+1);
            //拒绝接受规定文件格式之外的文件类型
            int allowFlag=0;
            int allowedExtCount=allowedExt.length;
            for (;allowFlag<allowedExtCount;allowFlag++){
                if (allowedExt[allowFlag].equals(t_ext)){
                    break;
                }
            }
            if (allowFlag==allowedExtCount){
                out.print("上传文件类型错误");
                return;
            }
            long now=System.currentTimeMillis();
            String u_name="E:/Auditing/"+String.valueOf(now)+"."+t_ext;
            System.out.println("文件保存路径"+u_name);
            if ("a".equals(choice)){
                System.out.println(choice);
                user.setFrontcardimg(u_name);
            }else if ("b".equals(choice)){
                System.out.println(choice);
                user.setVersocardimg(u_name);
            }else if ("c".equals(choice)){
                System.out.println(choice);
                user.setLicenseimg(u_name);
            }
            System.out.println(user);
            userService.update(user);
            try {
                //保存文件
                fileItem.write((new File(u_name)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void init() throws ServletException {
        userService=new UserService();
    }
}
