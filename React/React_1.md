# React



## Angular vs Vue vs React

* Angular - Full Framework
* Vue - Framework and Library
* React - Library



## React Component

* Component
  * 내가 만든 컴포넌트를 사용
  * 리액트에서는 Component Tree
  * HTML에서는 DOM Tree
* Virtual DOM?
  * DOM을 직접 제어하는 경우
    * 바뀐 부분만 정확히 바꿔야함
  * DOM을 직접 제어하지 않는 경우
    * 가상의 돔 트리를 사용해서,
    * 이전 상태와 이후 상태를 비교하여,
    * 바뀐 부분을 찾아내서 자동으로 바꾼다.
* Client Side Rendering (CSR)
  * JS 모두 다운받아진 후 리액트 애플리케이션이 정상 실행된 후 화면을 보여줌
  * HTML -> JS -> React 소스코드 --이제부터 볼 수 있음--> view!
* Server Side Rendering (SSR) 
  * 화면 먼저 보여주고 작동은 JS 모두 다운받아 리액트 애플리케이션이 정상 싱행된 후 사용 가능
  * HTML --이벤트 작동하지 않지만 보여짐--> JS -> React --이제부터 작동가능--> view!



~~~react
ReactDOM.render(
	<HelloMessage name="test">메세지</HelloMessage>
);

class HelloMessage...
~~~



* HTML에서 javascript를 이용해 만드는 경우...

```html
<script type="text/javascript">
    const root = document.querySelector('#root');
    const btn_plus = document.querySelector('#btn_plus');

    let i = 0;

    root.innerHTML = "<p>init : 0</p>";
    btn_plus.addEventListener('click', () => {
        root.innerHTML = `<p>init : ${++i}</p>`;
    })
</script>
```

```html
<script>
    const component = {
            message: 'init',
            count: 0,
            render() {
                return `<p>${this.message} : ${this.count}</p>`;
            }
        };

        function render(rootElement, component) {
            rootElement.innerHTML = component.render();
        }

        //초기화
        render(document.querySelector('#root'), component);

        document.querySelector('#btn_plus').addEventListener('click', () => {
            component.message = 'update';
            component.count = component.count + 1;

            render(document.querySelector('#root'), component);
        });
</script>
```



* 리액트에서 만드는 경우

  ~~~javascript
  //이걸 리액트로 표현하자면 <p>`${props.message} : ${props.count}`</p>
      const Component = props => {
          return React.createElement('p', null, `${props.message} : ${props.count}`);
      };
  
  
      ReactDOM.render(
          React.createElement(Component, {message: 'init', count: 0}, null),
          document.querySelector('#root')
      );
  
      document.querySelector('#btn_plus').addEventListener('click', () => {
          ReactDOM.render(
              React.createElement(Component, {message: 'update', count: 10}, null),
              document.querySelector('#root')
          );
      })
  ~~~

  

* Hooks

  * 컴포넌트 내부에 상태가 있다면, class

  * 컴포넌트 내부에 상태가 없다면, 

    * 라이프 사이클 사용 : class
    * 라이프 사이클 관계 x : function

  * Class 컴포넌트 작성법 :

    ~~~javascript
    import React from 'react';
    
    //정의
    class ClassComponent extends React.Component {
      render() {
        return (<div> Hello </div>);
      }
    }
    ~~~

    ~~~javascript
    //정 의
    class ClassComponent extends React.Component {
      render() {
        return <div>Hello</div>;
      }
    }
    
    //사 용 법
    //ReactDOM.render(<div>Hello</div>, document.getElementById('root'));
    
    ReactDOM.createRoot(document.getElementById('root')).render(
      <ClassComponent/>,
    );
    ~~~

  * Function 컴포넌트 작성법 :

    ~~~javascript
    //정 의 1
    // function FunctionComponenet() {
    //     return <div>Hello</div>;
    // }
    
    //정 의 2
    const FunctionComponent = () => {
      return <div>Hello</div>;
    }
    
    //사 용
    //ReactDOM.render(<FunctionComponent/>, document.getElementById("root"));
    ReactDOM.createRoot(document.getElementById("root")).render(
      <FunctionComponent/>
    );
    ~~~

  * createElement 함수

    ~~~javascript
    React.createElement(
      type, // 태그 이름 문자열 | 리액트 컴포넌트 | React.Fragment
      [props], // 리액트 컴포넌트에 넣어주는 데이터 객체
      [ ...children ] // 자식으로 넣어주는 요소들
    )
    ~~~

    ~~~javascript
    1. 태그 이름 문자열 type
    ReactDOM.render(
      React.createElement('h1', null, `type 이 "태그 이름 문자열" 입니다.`),
      document.querySelector('#root')
    )
    
    // 2. 리액트 컴포넌트 type
    const Component = () => {
      return React.createElement('p', null, `type 이 "React 컴포넌트" 입니다.`);
    };
    
    // <Component></Component> => <p>type 이 "React 컴포넌트" 입니다.</p>
    ReactDOM.render(
      React.createElement(Component, null, null),
      document.querySelector('#root')
    )
    
    // 3. React.Fragment
    ReactDOM.render(
      React.createElement(
        React.Fragment,
        null,
        `type 이 "React Fragment1" 입니다.`,
        `type 이 "React Fragment2" 입니다.`,
        `type 이 "React Fragment3" 입니다.`
      ),
      document.querySelector("#root")
    )
    
    // 4. 복잡한 리액트 엘리먼트 모임
    ReactDOM.render(
      React.createElement('div', null,
    		React.createElement('div', null,
    			React.createElement('h1', null, "주제"),
    			React.createElement('ul', null,
    				React.createElement('li', null, "React"),
    				React.createElement('li', null, "Vue")
    			)
    		)
    	),
      document.querySelector('#root')
    )
    ~~~

  * Babel?? JSX 코드??

    * React.createElement가 위 처럼 복잡하기 때문에 JSX를 써서 가독성을 올림
    * 또한 babel과 같은 컴파일 과정에서 문법적 오류를 인지할 수 있음
    
    ~~~html
    <script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
    <script type="text/babel">
    // 우리가 작성한 어떤 코드 => 순수하게 실행할 수 있는 자바스크립트
        // babel
        ReactDOM.render(
            React.createElement('div', null,
                React.createElement('div', null,
                    React.createElement('h1', null, "주제"),
                    React.createElement('ul', null,
                        React.createElement('li', null, "React"),
                        React.createElement('li', null, "Vue")
                    )
                )
            ),
            document.querySelector('#root')
        )
    
    
    //=> 자동으로 변경됨
        
        
        ReactDOM.render(
            <div>
                <div>
                    <h1>주제</h1>
                    <ul>
                        <li>React</li>
                        <li>Vue</li>
                    </ul>
                </div>
            </div>
            , document.querySelector('#root')
        )
    </script>
    ~~~
    
    * JSX 문법
    
      * 최상위 Element는 하나여야한다. => <> 최상위 노드, 최상위 노드 </> 하면 여러개의 최상위 노드를 만들 수 있긴 하다.
    
      * 최상위 요소를 리턴하는 경우 ()로 감싸야 합니다.
    
      * 자식들을 바로 랜더링하고 싶으면 <>자식들</>를 사용합니다. => Fragment
    
      * 자바스크립트 표현식을 사용하려면, {표현식}을 이용합니다.  => ${표현식}을 안써도 된다.
    
        ~~~java
        const title = "주제!!!";
        
        ReactDOM.render(
                <div>{title}</div>
          )
          , ...
        )
    
      * if문은 사용할 수 없음. 삼항 연산자 혹은 && 이용
    
      * style 을 이용해 인라인 스타일링 가능
    
      * class 대신 className을 사용해 class 적용할 수 있음
    
      * 자식 요소가 있으면 꼭 닫아야 하고, 자식 요소가 없으면 열면서 닫아야 한다.