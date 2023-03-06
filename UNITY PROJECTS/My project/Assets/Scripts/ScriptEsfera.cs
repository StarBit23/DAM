using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ScriptEsfera : MonoBehaviour
{
    public float forceValue;
    private Rigidbody rigidbody;
    public float jumpValue;
    // Start is called before the first frame update
    void Start(){
        rigidbody = GetComponent<Rigidbody> ();
    }

    // Update is called once per frame
    void Update(){
        if (Input.GetButtonDown ("Jump") && Mathf.Abs(rigidbody.velocity.y) < 0.01f)
            rigidbody.AddForce(Vector3.up * jumpValue, ForceMode.Impulse);
    }

    void FixedUpdate(){
        rigidbody.AddForce(new Vector3(Input.GetAxis("Horizontal"),
                                       0,
                                       Input.GetAxis("Vertical"))*forceValue);
    }
}
