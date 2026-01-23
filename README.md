# EasyDSA - 积累算法数据资产，用Java写数据结构和算法更容易，纯原生IDE实现 / Accumulating Algorithm Data Assets, Making Data Structures and Algorithms Easier with Java, Pure Native IDE Implementation

EasyDSA 是一个专注于让Java开发者更容易编写和理解数据结构与算法的项目，提供纯原生IDE实现的解决方案，沉淀自己的算法数据资产，下次面试更加简单。
EasyDSA is a project focused on making it easier for Java developers to write and understand data structures and algorithms, providing pure native IDE implementation solutions, accumulating your own algorithm data assets, making the next interview easier.

## 🌟 特点 / Features

### 中文特点
- **纯原生IDE实现**：无需复杂框架，直接在IDE中运行和调试
- **自动化执行系统**：使用注解控制解决方案的执行（`@RunSolution` 和 `@RunOnce`）
- **灵活的运行方式**：支持命令行参数运行特定解决方案
- **丰富的题库**：包含多种类型的算法问题（LeetCode、排序、树遍历等）
- **测试驱动**：每个解决方案都配有完整的测试用例
- **易于扩展**：添加新解决方案只需实现标准接口并添加注解
- **智能匹配**：支持部分名称匹配和大小写不敏感的搜索
- **数据资产沉淀**：将算法实现积累为个人技术资产

### English Features
- **Pure Native IDE Implementation**: No complex frameworks, run and debug directly in IDE
- **Automated Execution System**: Use annotations to control solution execution (`@RunSolution` and `@RunOnce`)
- **Flexible Execution**: Support command-line arguments to run specific solutions
- **Rich Problem Set**: Contains various types of algorithm problems (LeetCode, sorting, tree traversal, etc.)
- **Test Driven**: Each solution comes with complete test cases
- **Easy to Extend**: Add new solutions by simply implementing the standard interface and adding annotations
- **Smart Matching**: Support partial name matching and case-insensitive search
- **Data Asset Accumulation**: Accumulate algorithm implementations as personal technical assets

## 🚀 使用方法 / Usage

### 构建项目 / Build Project
```bash
# 编译项目
mvn clean compile

# 打包为可执行JAR
mvn clean package
```

### 运行解决方案 / Running Solutions

#### 中文说明
```bash
# 运行所有解决方案（默认行为）
java -jar target/easydsa-1.0-SNAPSHOT.jar

# 运行特定解决方案
java -jar target/easydsa-1.0-SNAPSHOT.jar BinarySearchSolution

# 通过部分名称匹配运行（例如：运行所有包含"Search"的解决方案）
java -jar target/easydsa-1.0-SNAPSHOT.jar Search

# 运行多个解决方案（通过多个关键词）
java -jar target/easydsa-1.0-SNAPSHOT.jar Binary Tree Sort

# 在开发环境中直接运行
mvn exec:java -Dexec.mainClass="dsa.Main"
mvn exec:java -Dexec.mainClass="dsa.Main" -Dexec.args="BinarySearch"
```

#### English Instructions
```bash
# Run all solutions (default behavior)
java -jar target/easydsa-1.0-SNAPSHOT.jar

# Run specific solution
java -jar target/easydsa-1.0-SNAPSHOT.jar BinarySearchSolution

# Run by partial name matching (e.g., run all solutions containing "Search")
java -jar target/easydsa-1.0-SNAPSHOT.jar Search

# Run multiple solutions (by multiple keywords)
java -jar target/easydsa-1.0-SNAPSHOT.jar Binary Tree Sort

# Run directly in development environment
mvn exec:java -Dexec.mainClass="dsa.Main"
mvn exec:java -Dexec.mainClass="dsa.Main" -Dexec.args="BinarySearch"
```

## 🏷️ 注解说明 / Annotation Guide

### 中文注解说明
- `@RunSolution(runByDefault = true)`: 标记解决方案是否默认运行
- `@RunOnce`: 临时标记解决方案，使其成为唯一运行的解决方案（优先级最高）

### English Annotation Guide
- `@RunSolution(runByDefault = true)`: Mark if the solution should run by default
- `@RunOnce`: Temporarily mark the solution to be the only one executed (highest priority)

## 📁 项目结构 / Project Structure

```
src/
├── main/
│   └── java/
│       └── dsa/
│           ├── annotation/          # 注解定义
│           ├── solution/            # 解决方案接口和实现
│           │   ├── lc/             # LeetCode 题目解决方案
│           │   ├── sort/           # 排序算法解决方案  
│           │   └── tree/           # 树算法解决方案
│           └── testcase/           # 测试用例
└── test/
    └── java/                       # 单元测试
```

## 🧩 支持的问题类型 / Supported Problem Types

### 中文支持类型
- **LeetCode 经典题目**: 包括 Two Sum, Valid Parentheses, Group Anagrams 等
- **排序算法**: 包括基础排序、快速排序、归并排序、二分查找等
- **树算法**: 包括二叉树 BFS/DFS 遍历等
- **链表操作**: 包括链表反转、合并有序链表等
- **动态规划**: 包括爬楼梯、最大子数组和等

### English Supported Types
- **LeetCode Classic Problems**: Including Two Sum, Valid Parentheses, Group Anagrams, etc.
- **Sorting Algorithms**: Including basic sort, quick sort, merge sort, binary search, etc.
- **Tree Algorithms**: Including binary tree BFS/DFS traversal, etc.
- **Linked List Operations**: Including list reversal, merge sorted lists, etc.
- **Dynamic Programming**: Including climbing stairs, maximum subarray, etc.

## 💼 面试准备 / Interview Preparation

### 中文说明
EasyDSA 不仅是一个学习工具，更是你的个人算法资产库：
- 每个解决方案都是你亲手编写的代码资产
- 可以随时回顾和优化已实现的算法
- 为下一次面试积累宝贵的实践经验
- 形成属于自己的算法知识体系

### English Instructions
EasyDSA is not just a learning tool, but also your personal algorithm asset library:
- Each solution is code asset written by you personally
- You can review and optimize implemented algorithms anytime
- Accumulate valuable practical experience for the next interview
- Form your own algorithm knowledge system

## 🔧 开发指南 / Development Guide

### 添加新的解决方案 / Adding New Solutions
1. 实现 `Solution<INPUT, RESULT>` 接口
2. 创建对应的测试用例类
3. 添加 `@RunSolution(runByDefault = true)` 注解
4. 将解决方案类放在合适的包中（如 `lc`, `sort`, `tree`）

### Adding New Solutions
1. Implement the `Solution<INPUT, RESULT>` interface
2. Create corresponding test case class
3. Add `@RunSolution(runByDefault = true)` annotation
4. Place the solution class in the appropriate package (e.g., `lc`, `sort`, `tree`)

## 🛠️ 技术栈 / Tech Stack

- **Java 8+**: 核心编程语言 / Core programming language
- **Maven**: 项目管理和依赖管理 / Project management and dependency management
- **Reflections**: 类路径扫描 / Classpath scanning
- **Apache Commons**: 工具库 / Utility library
- **Jackson**: JSON 处理 / JSON processing
- **Lombok**: 代码简化 / Code simplification

## 🤝 贡献 / Contributing

欢迎提交 Issue 和 Pull Request 来改进项目！  
Feel free to submit Issues and Pull Requests to improve the project!

## 📄 许可证 / License

此项目采用 MIT 许可证 - 查看 [LICENSE](LICENSE) 文件了解详情。  
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🎯 目标 / Goals

- 让Java开发者更容易编写和理解数据结构与算法
- 提供纯原生IDE实现的解决方案，无需复杂配置
- 创建一个可扩展的学习和实践平台
- 让算法实现成为自己的数据资产沉淀
- 为下一次面试做好充分准备
- 促进算法知识的分享和传播

Make it easier for Java developers to write and understand data structures and algorithms
Provide pure native IDE implementation solutions without complex configurations
Create an extensible learning and practice platform
Turn algorithm implementations into your own data asset accumulation
Prepare thoroughly for the next interview
Promote the sharing and dissemination of algorithm knowledge