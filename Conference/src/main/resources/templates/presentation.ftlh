<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Presentation</title>
</head>
<body>
<h3>Presentations:</h3>
<#if presentations??>
   <#list presentations as presentation>
       <p>Id: ${presentation.getId()}
       <p>Name: ${presentation.getName()}
       <form method="post" action="/presentation/update/${presentation.getId()}">
           <input type="text" name="name" placeholder="Name">
           <button type="submit">Update name</button>
       </form>
   </#list>
</#if>
</br>

<form method="post">
    <input type="text" name="name" placeholder="Name">
    <button type="submit">Create presentation</button>
</form>
</br>

<form method="post" action="/presentation/schedule">
    <input type="text" name="presentationId" placeholder="Presentation id">
    <input type="text" name="roomNumber" placeholder="Room number">
    <input type="text" name="startTime" placeholder="Start time">
    <input type="text" name="endTime" placeholder="End time">
    <button type="submit">Choose schedule</button>
</form>
</body>
</html>