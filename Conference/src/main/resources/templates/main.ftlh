<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
<#if rooms??>
    <#list rooms as room>
    <h3>Room: ${room.getNumber()}</h3>
       <#if schedules??>
          <#list schedules as schedule>
               <#if room.getNumber() == schedule.getRoom().getNumber()>
                   <p>Name of presentation: ${schedule.getPresentation().getName()}
                   <p>Start time: ${schedule.getStartTime()}
                   <p>End time: ${schedule.getEndTime()}
               </#if>
          </#list>
        </#if>
    </#list>
</#if>
</body>
</html>