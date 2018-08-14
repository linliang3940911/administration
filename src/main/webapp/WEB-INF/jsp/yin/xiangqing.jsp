<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>加班登记详情</title>
</head>
<body>
<div class="x-window-bwrap" id="ext-gen4600">
    <div class="x-window-ml">
        <div class="x-window-mr">
            <div class="x-window-mc" id="ext-gen4604">
                <div class="x-window-body" id="ext-gen4601"
                     style="padding: 20px; overflow: auto; width: 596px; height: 270px; background-color: rgb(255, 255, 255);">
                    开始时间：<span style="color:#228833; font-weight:bold"><fmt:formatDate value="${jb.kaishitime}" pattern="yyyy/MM/dd HH:mm"/></span> ---- 结束时间：
                    <span style="color:#228833; font-weight:bold"><fmt:formatDate value="${jb.jieshutime}" pattern="yyyy/MM/dd HH:mm"/></span><br>
                    <div style="color:#333; padding:20px;">${jb.jiabanyuanyin}</div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
