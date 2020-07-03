import styled from 'styled-components';
import { Panel } from '@util-components';

export const RegisterWrapper = styled.section`
  h1 {
    color: #ffffff;
  }

  //Todo: figure out why this is necessary
  margin-top: 100px;
`;

export const RegisterPanel = styled(Panel)`
  justify-content: space-between;
`;

export const PanelHeader = styled.div`
  position: relative;

  h2 {
    position: relative;
    padding: 0;
    color: #722100;
    font-family: Raleway;
    font-size: 20px;
    font-weight: bold;
    letter-spacing: 0.75px;
    line-height: 24px;
    text-align: center;
    margin: 0;
    animation: fadeIn 0.5s ease-in;
  }

  .progress-bar {
    position: absolute;
    height: 1px;
    width: 100%;
    background: #722100;
    top: 30px;
  }
`;

export const PanelBody = styled.div`
  height: 100% !important;
  animation: fadeIn 0.2s ease-in;

  a {
    display: block;
    color: #6D453D;
    font-family: Raleway;
    font-size: 12px;
    font-weight: 500;
    letter-spacing: 0.75px;
    line-height: 14px;
    text-align: center;
    text-decoration: none;

    &:hover {
      font-weight: 700;
    }
  }

  .a-with-spacing {
    margin: 24px 0;
    font-size: 16px;
  }

  ul {
    padding: 0;
    margin: 0;
  }
`;

export const Actions = styled.div`
  height: 32px;
  box-sizing: border-box;
  display: flex;
  justify-content: center;
  align-items: center;

  button {
    height: 40px;
    width: 250px;
    border-radius: 10px;
    font-family: Raleway;
    font-size: 12px;
    font-weight: bold;
    letter-spacing: 0.89px;
    line-height: 11px;
    text-align: center;
    text-transform: uppercase;
    border: solid 2px #449df5;
    box-sizing: border-box;
  }

  .btn-solid {
    background-color: #AC6C5F;
    color: #ffffff;
  }

  .btn-outlined {
    background-color: #ffffff;
    color: #AC6C5F;
    filter: opacity(40%);
  }
`;
