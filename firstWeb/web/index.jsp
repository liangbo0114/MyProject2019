<%--
  Created by IntelliJ IDEA.
  User: LB
  Date: 2019/2/20
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <%--<link rel="stylesheet" href="plugin/css/demo.css" type="text/css">--%>
    <link rel="stylesheet" href="plugin/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="plugin/js/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="plugin/js/jquery.ztree.core.js"></script>
  </head>
  <body>
  <script type="text/javascript">
      var setting = {	};

      var zNodes =[
          { name:"父节点1 - 展开", open:true,
              children: [
                  { name:"父节点11 - 折叠",
                      children: [
                          { name:"叶子节点111"},
                          { name:"叶子节点112"},
                          { name:"叶子节点113"},
                          { name:"叶子节点114"}
                      ]},
                  { name:"父节点12 - 折叠",
                      children: [
                          { name:"叶子节点121"},
                          { name:"叶子节点122"},
                          { name:"叶子节点123"},
                          { name:"叶子节点124"}
                      ]},
                  { name:"父节点13 - 没有子节点", isParent:true}
              ]},
          { name:"父节点2 - 折叠",
              children: [
                  { name:"父节点21 - 展开", open:true,
                      children: [
                          { name:"叶子节点211"},
                          { name:"叶子节点212"},
                          { name:"叶子节点213"},
                          { name:"叶子节点214"}
                      ]},
                  { name:"父节点22 - 折叠",
                      children: [
                          { name:"叶子节点221"},
                          { name:"叶子节点222"},
                          { name:"叶子节点223"},
                          { name:"叶子节点224"}
                      ]},
                  { name:"父节点23 - 折叠",
                      children: [
                          { name:"叶子节点231"},
                          { name:"叶子节点232"},
                          { name:"叶子节点233"},
                          { name:"叶子节点234"}
                      ]}
              ]},
          { name:"父节点3 - 没有子节点", isParent:true}

      ];

      $(document).ready(function(){
          $.fn.zTree.init($("#treeDemo"), setting, zNodes);
      });


  </script>
  <div>
    <div class="zTreeDemoBackground left">
      <ul id="treeDemo" class="ztree"></ul>
    </div>
  </div>
  </body>
</html>
