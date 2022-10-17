
# git基本操作
常用命令：
* git clone
* git push
* git add
* git commit
* git checkout
* git pull

## 创建仓库
    #初始化git仓库
    git init 

    #新建目录，初始化git仓库
    git init [project-name]

    #下载整个仓库
    git clone

## 信息配置

    #查看当前的git配置
    git global --list

    #编辑git配置信息
    git config --global -e

    #查看git配置信息
    git config --global -l
        
    #关联远程仓库
    git remote add origin [address]
    
 
## 提交修改

    #查看当前仓库状态
    git status

    #查看文件修改记录
    git diff file

    #查看git配置信息
    git add file
    
    #查看git配置信息
    git commit -m <修改信息>
    
    #提交所有文件
    git add .
    #推送到远程仓库
    git push origin [分支名]
    

## 撤销提交
    #查看commit哈希值
    git log
    
    #撤销commit，保留工作区改动记录
    git reset --soft [commit-hashcode]
    
    #撤销commit，撤销工作区改动记录
    git reset --hard [commit-hashcode]
    
    #取消远程提交
    git push --force
    

## 分支管理
    #查看分支
    git branch
    
    #创建分支
    git branch <branchname>
    
    #切换分支
    git checkout 
    
    #删除分支
    git branch -d <branchname>
    
    #分支合并
    git merge



