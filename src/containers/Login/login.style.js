import styled from 'styled-components';
import { GradientBackground, Panel } from '@util-components';



export const LoginWrapper = styled(GradientBackground)`
  h1 {
    color: #FFEACF;
  }
  margin-top: 60px;
`;

export const LoginPanel = styled(Panel)``;

export const PanelBody = styled.div`
  display: grid;
  flex-direction: column;

  .provider-login-compt {
  font-family: inherit;
  width: 100%;
  border: 0;
  border-bottom: 2px solid $gray;
  outline: 0;
  font-size: 1.3rem;
  color: $white;
  padding: 7px 0;
  background: transparent;
  transition: border-color 0.2s;
  }

  
  .registerButton{
  display: block;
  cursor: pointer;
  outline: none;
  border: none;
  background-color: var(--light);
  width: 400px;
  height: 70px;
  border-radius: 30px;
  font-size: 1.5rem;
  color: var(--text);
  background-size: 100% 100%;
  box-shadow: 0 0 0 7px var(--light) inset;
  margin-bottom: 15px;
  background-color: #73392F;
  opacity: 0.8;
  }
  
 a.registerButton{
 display:inline-block;
 padding:0.35em 1.2em;
 border:0.1em solid #FFFFFF;
 margin:0 0.3em 0.3em 0;
 border-radius:0.12em;
 box-sizing: border-box;
 text-decoration:none;
 font-family:'Roboto',sans-serif;
 font-weight:300;
 color:#FFFFFF;
 text-align:center;
 transition: all 0.2s;
  border-radius: 15px;
  }
  
  a.registerButton:hover{
  color:#FFFFFF;
  background-color:#AC6C5F;
  }
  
  button:active{
  color:#7d0000;
  background-color:#fff;
  }
  
  .inputWebID {
  font-family: inherit;
  width: 100%;
  border: 0;
  border-bottom: 2px solid $gray;
  outline: 0;
  font-size: 1.3rem;
  color: $white;
  padding: 7px 0;
  background: transparent;
  transition: border-color 0.2s;
  }
  
`;

export const LoginTitle = styled.span`
  color: #656e75;
  font-family: 'Amatic SC', cursive;
  font-size: 16px;
  font-weight: 500;
  letter-spacing: 1.2px;
  line-height: 19px;
  text-align: center;
  position: relative;
  margin: 30px 0;
  display: inline-block;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;

  &::before,
  &::after {
    width: 32%;
    content: '';
    background: #00000;
    height: 1px;
    box-sizing: border-box;
    top: 50%;
  }

  span {
    padding: 0 5px;
  }

  &::before {
    right: 0;
  }

  &::after {
    left: 0;
  }
`;
