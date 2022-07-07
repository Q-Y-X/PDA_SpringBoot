//此服务无法连接成功，原因未知！！！！！！！！！
//1.导入模块
const http = require('http')
const fs = require('fs')
const path = require('path')

//2.1创建web服务器
const server = http.createServer()

//2.2监听 web服务器的request请求
server.on('request',(req,res) => {
//2.3    获取到客户端请求的URL地址
//    /webapp/index01.html
    const url =req.url
    console.log(req.url)
//2.4把请求的URL地址映射为具体文件的存放路径
    let fpath =''

    if(url === '/'){
        //如果客户端地址栏ip地址后什么都不输入的话，默认为/，返回index页面
        fpath = path.join(__dirname, '../../index01.html')
        console.log(fpath)
    }else{
        //拼接相应请求的url
        fpath = path.join(__dirname, '../../',url)
        console.log(fpath)
    }

// 2.5读取对应请求路径（磁盘中）的文件
    fs.readFile(fpath,'utf8',(err,dataStr) => {
    //    读取失败，返回错误信息
        if(err){
            return res.end('404 Not found')
        //    读取成功，将内容返回客户端
            res.end(dataStr)
        }
    })
})

//3.1启动服务器
server.listen(8081,() => {
    console.log('server running at http://127.0.0.1:8081')
})
