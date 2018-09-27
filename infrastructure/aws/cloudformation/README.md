<ul>
<li>csye-cf-networking.yaml : YAML template defining the resources</li>
<li>csye6225-aws-cf-create-stack.sh : This script uses <u>startmyinstance-parameters.json</u> which defines the parameters and <u>csye-cf-networking.yaml</u> which defines the stack template.</li>
<li>csye6225-aws-cf-terminate-stack.sh : This script deletes the stack.</li> 
</ul>
<p>Cloud Formation</p>
<p>To create Stack</p>
Run commands: Open terminal and run the following commands
<ul>
   <li>To launch : ./csye6225-aws-cf-create-stack.sh 'stackName' where stackname needs to passed through command lime </li>
</ul>

<p>To termiante Stack</p>
Run commands: Open terminal and run the following commands
<ul>
   <li>To launch : ./csye6225-aws-cf-terminate-stack.sh 'stackName' where stackname needs to passed through command lime </li>
</ul>
