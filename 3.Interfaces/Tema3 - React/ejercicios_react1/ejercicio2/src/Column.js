const Column = (props) => {
      return props.links.map((link) => <li key= {link.id}> {link.name}: <a href={link.anchor}>{link.anchor}</a></li>);
  }

export default Column;