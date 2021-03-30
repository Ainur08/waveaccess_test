<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin</title>
</head>
<body>
<#if users??>
    <#list users as user>
        <p>Name: ${user.getName()}
        <p>Email: ${user.getEmail()}

        <form method="post" action="/admin/delete/${user.getId()}">
            <button type="submit">Delete</button>
        </form>

        <form method="post" action="/admin/role/${user.getId()}">
            <button type="submit">Make presenter</button>
        </form>

        <form method="post" action="/admin/update/${user.getId()}">
            <input type="text" name="name" placeholder="Name">
            <input type="text" name="email" placeholder="Email">
            <button type="submit">Update name and email</button>
        </form>
    </#list>
</#if>
</body>
</html>